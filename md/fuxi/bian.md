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

1. 在经常需要搜索查询的列上创建索引，可以加快搜索的速度；
 
2. 在作为主键的列上创建索引，强制该列的唯一性和组织表中数据的排列结构；
 
3. 在经常用在连接的列上创建索引，这些列主要是一些外键，可以加快连接的速度；
 
4. 在经常需要根据范围进行搜索的列上创建索引，因为索引已经排序，其指定的范围是连续的；
 
5. 在经常需要排序的列上创建索引，因为索引已经排序，这样查询可以利用索引的排序，加快排序查询 时间；
 
6. 在经常使用在Where子句中的列上面创建索引，加快条件的判断速度；
 
7. 为经常出现在关键字order by、group by、distinct后面的字段，建立索引。

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
加锁实现

线程 1 过来通过 lock.lock() 方式获取锁，获取锁的过程就是通过 CAS 操作 volatile 变量 state 将其值从 0 变为 1。如果之前没有人获取锁，那么 state 的值肯定为 0，此时线程 1 加锁成功将 state = 1。
线程 1 加锁成功后还有一步重要的操作，就是将 OwnerThread 设置成为自己。
可重入实现

重入就是判断当前锁是不是自己加上的，如果是就代表自己可以再次上锁，每重入一次就是将 state值加 1

互斥实现

线程 2 也跑过来想加锁，CAS 操作尝试将 state 从 0 变成 1， 此时发现 state 已经不是0了，说明此锁已经被别人拿到了。接着线程 2 会判断一下这个锁是不是线程 2 加上的，发现 OwnerThread=线程1，明显不是自己加上的 ，加锁失败。

线程 2 的加锁失败后，AQS 会将 线程 2 放入 CLH 等待队列中。

此时线程 1 业务执行完了，开始释放锁：

将 state 值改为 0；
将 OwnerThread 设为 null；
通知线程 2 锁已经释放，该线程 2 获取锁了；
线程 2 立马开始尝试获取锁，CAS 尝试将 state 值设为 1，如果成功将 OwnerThread 设为自己 线程2。此时线程 2 便成功获取到了锁。


TCP连接建立是一对一的，能不能进行优化，多个客户端复用一个TCP连接，如果可以该怎么实现；在多路复用TCP时，同一个TCP里有大量客户端映射到一个TCP连接里，如何保证这些延时的一致性。比如我用手机查一个报价，是1块钱（延迟），用另一个手机查到是8毛钱（最新），那么客户肯定会投诉我们。如何保证一致。