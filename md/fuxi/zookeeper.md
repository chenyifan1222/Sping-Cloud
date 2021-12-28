zookeeper

**Zookeeper leader 选举**

半数通过
　　　　– 3台机器 挂一台 2>3/2
　　　　– 4台机器 挂2台 2！>4/2

![img](https://images2015.cnblogs.com/blog/183233/201603/183233-20160316224650521-63353773.png)

![img](https://images2015.cnblogs.com/blog/183233/201603/183233-20160316224702381-344312695.png)





**Zookeeper工作原理**

 Zookeeper的核心是原子广播，这个机制保证了各个server之间的同步。实现这个机制的协议叫做Zab协议。Zab协议有两种模式，它们分别是恢复模式和广播模式。

当服务启动或者在领导者崩溃后，Zab就进入了恢复模式，当领导者被选举出来，且大多数server的完成了和leader的状态同步以后，恢复模式就结束了。

**数据一致性与paxos 算法**　



# zookeeper临时顺序节点实现分布式锁



临时节点（EPHEMERAL） ：session链接断开就没了；不能创建子节点；不能同名