jvm

4核  8G

怎么让cpu 跑到75%？



怎么让内存跑到6G？







jvm为什么分代？为什么GC次数默认15次进入old区？

为什么young区又分为 eden 区跟s1 s0 区？

过程：触发young Gc Eden 跟s0 放到 s1区 s区达到某个阈值放到old区

所有Gc实现都是为了减少full Gc次数，增加系统的吞吐

jvm

 host spot

触发minor的情况

1.eden或者S区空间不够

2.full Gc  触发会触发minor



1.7  permspace  跟1.8 mate space 区别？

1.7之前 jvm自己的空间

1.8本地内存



Gc root 



分代收集算法

young 区 s0 s1 复制算法 

old 区 标记真整理



java对象的生命周期