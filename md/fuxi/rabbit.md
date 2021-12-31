rabbitmq消费消息确认及消费失败重试机制

消费者消息确认

RabbitMQ是阅后即焚机制，RabbitMQ确认消息被消费者消费后会立刻删除。

设想这样的场景：

1）RabbitMQ投递消息给消费者
2）消费者获取消息后，返回ACK给RabbitMQ
3）RabbitMQ删除消息
4）消费者宕机，消息尚未处理
这样，消息就丢失了。因此消费者返回ACK的时机非常重要。


而SpringAMQP则允许配置三种确认模式：

•manual：手动ack，需要在业务代码结束后，调用api发送ack。

•auto：自动ack，由spring监测listener代码是否出现异常，没有异常则返回ack；抛出异常则返回nack

•none：关闭ack，MQ假定消费者获取消息后会成功处理，因此消息投递后立即被删除

一般，我们都是使用默认的auto即可。

配置方式
spring:
    rabbitmq:
        listener:
            simple:
                acknowledge-mode: 确认模式

消费者失败重试机制
当消费者出现异常后，消息会不断requeue（重入队）到队列，再重新发送给消费者，然后再次异常，再次requeue，无限循环，导致mq的消息处理飙升，带来不必要的压力

本地重试
我们可以利用Spring的retry机制，在消费者出现异常时利用本地重试，而不是无限制的requeue到mq队列。
spring:
    rabbitmq:
        listener:
            simple:
                retry:
                    enabled: true # 开启消费者失败重试
                    initial-interval: 1000ms # 初识的失败等待时长为1秒
                    multiplier: 1 # 失败的等待时长倍数，下次等待时长 = multiplier * last-interval
                    max-attempts: 3 # 最大重试次数
                    stateless: true # true无状态；false有状态。如果业务中包含事务，这里改为false

重启consumer服务，重复之前的测试。可以发现：

在重试3次后，SpringAMQP会抛出异常AmqpRejectAndDontRequeueException，说明本地重试触发了
查看RabbitMQ控制台，发现消息被删除了，说明最后SpringAMQP返回的是ack，mq删除消息了

失败策略
在之前的测试中，达到最大重试次数后，消息会被丢弃，这是由Spring内部机制决定的。

在开启重试模式后，重试次数耗尽，如果消息依然失败，则需要有MessageRecovery接口来处理，它包含三种不同的实现：

RejectAndDontRequeueRecoverer：重试耗尽后，直接reject，丢弃消息。默认就是这种方式

ImmediateRequeueMessageRecoverer：重试耗尽后，返回nack，消息重新入队

RepublishMessageRecoverer：重试耗尽后，将失败消息投递到指定的交换机


比较优雅的一种处理方案是RepublishMessageRecoverer，失败后将消息投递到一个指定的，专门存放异常消息的队列，后续由人工集中处理。

