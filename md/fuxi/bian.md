介绍下java 内存模型，为什么要这样设计
jvm的GC算法有哪些，介绍下。了解过哪些垃圾回收器，介绍下，G1回收器会在young gc的时候stop the world吗
解释下为什么要三次握手和四次挥手，time wait是干嘛的，如何优化time wait
threadlocal了解吗；使用不当有什么问题，怎么解决
介绍下线程池；如果阻塞队列为20，核心线程数10，此时来了30个任务，线程池创建了多少个线程；线程池有哪些拒绝策略；
reentrantlock实现原理，加入到队列队头的时候会做哪些处理
synchronized实现原理，synchronzied锁的升级过程
volatile了解吗，原理是什么，有哪些作用
redis哪些数据结构，redis string对比C的string做了哪些优化
redis zset的实现原理
redis 数据持久化的原理
redis怎么做rehash的
MySQL的索引原理，为什么要用B+树，建索引要注意哪些事项，联合索引了解吗，怎么建，要注意哪些。了解回表查询吗。
MySQL四种隔离级别介绍下，底层如何实现的
spring ioc和aop的原理 spring加载过程
链表如何判断是否有环，如何找到环的入口




项目中的工作亮点介绍下
了解元编程嘛，介绍下
了解java 响应式编程嘛，介绍下
spring如何解决循环依赖的
jvm如何解决循环引用的
了解哪些并行编程模型，介绍下；看过相关的论文嘛
reentrantlock和ReadWriteLock 类之间是什么关系；为什么要有ReadWriteLock
AQS的实现里，CAS获取锁的过程会不停的轮询cpu，AQS是如何优化的
TCP连接建立是一对一的，能不能进行优化，多个客户端复用一个TCP连接，如果可以该怎么实现；在多路复用TCP时，同一个TCP里有大量客户端映射到一个TCP连接里，如何保证这些延时的一致性。比如我用手机查一个报价，是1块钱（延迟），用另一个手机查到是8毛钱（最新），那么客户肯定会投诉我们。如何保证一致。