# redis应用实战注意事项（笔记）

相比原生 redis 客户端的优化：

1.通信方面优化(NIO)

2.是否采用异步通信（多线程）

3.针对key和value的序列化(数据的大小影响速度)

4.java8的特性

5.解决方案



# 使用中遇到的问题

缓存一致性的问题：

分场景看：只能保证弱一致性，不能保证强一致性

。先更新数据库，在删除缓存*(相当于被动更新)

1.更新数据库异常回滚

2.更新数据库成功，更新缓存失败  怎么解决？

.消息放到mq 重试

.解析mysql bin log 日志

。先删除缓存，在更新数据库

<img src="C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20210925213647148.png" alt="image-20210925213647148" style="zoom:25%;" />

缓存血崩：

导致原因 ：大量热点数据失效，redis出现故障

由redis的key过期导致的

。对redis的key的过期时间错开，过期时间设置随机值

。对于热点数据，没必要设置过期时间

。增加二级缓存 给数据库加互斥锁 防止数据库崩

缓存穿透：

redis和mysql都不存在的情况，有可能是恶意攻击





## 过期key的删除原理：

。被动删除

get name 

从过期的key存储表中拿到name对应的过期时间，发现过期返回失效

。主动删除

随机抽20个key ，删除这20个key中过期的

发现这20个key 中25%的过期了重新执行第一步





![image-20211227213352538](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227213352538.png)



![image-20211227213333332](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227213333332.png)



![image-20211227214100141](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227214100141.png)





![setimage-20211227214928426](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227214928426.png)

set应用场景:标签





![image-20211227215546555](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227215546555.png)



dain![image-20211227220354377](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211227220354377.png)





zset使用场景

点赞排名

热点话题排名
