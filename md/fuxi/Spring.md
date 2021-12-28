# Spring

谈谈对spring ioc 理解

IOC 控制反转，原来我们使用对象由使用者控制，有了spring 之后交给spring容器进行管理

DI 依赖注入 ，将对应的属性注入到具体的对象中@Autowired @Resource , 通过populateBean 方法完成属性注入的。

容器：存储对象，使用map结构存储对象，在spring 中存储对象的时候一般是三级缓存，

springObejcts 存放完整对象，earlySingletonObjects 存放半成品对象，singletonFactory用来存放lambda表达式和对象名称的映射。整个bean的生命周期，从创建到使用个销毁各个环节都是由容器帮我们控制的。

spring 中所有的bean 都是通过反射生成的，constructor,newInstance, 在整个流程中还有很多扩展点，比如有两个非常重要的接口BeanFactoryPostProcessor、BeanPostProcessor用来扩展功能，aop就是在ioc 的基础上扩展的，通过BeanPostProcessor实现的。ioc 除了这个还有一个很重要的属填充



循环依赖的问题怎么产生，怎么解决的？





Bean 生命周期？

![image-20211203101457009](C:\Users\EDZ\AppData\Roaming\Typora\typora-user-images\image-20211203101457009.png)



BeanFactory和FactoryBean区别？







Spring Aop 的底层原理实现？

总：aop概念  应用场景 动态代理

aop 是ioc 的一个扩展点，现有ioc 在有aop的，在整个io出的流程中，aop是整个ioc的一个扩展点作用在Bean 上， BeanPostProcessor

分：

bean 创建过程中有一个步骤可以对bean 进行扩展，在BeanPostProcessor的后置方法中实现

1.代理对象的创建过程（advice 切面 切点）

2.通过cglib或者jdk生成代理对象

3.在执行调用方法的时候，会调用生成的字节码文件中，直接找到DynamicAdvisoredInterceptorf方法，重整个方法开始执行的

4.根据之前定义好的通知来生成拦截器链

5.从拦截器链中获取依次执行的方法，重-1开始执行

**正常情况：**

![one-ok](https://img-blog.csdn.net/20160811192425854)



**异常情况：**

![one-exception](https://img-blog.csdn.net/20160811192446479)





spring 事物如何回滚？



spring 事物传播特性？（7zhong）



A方法调用B方法，两个都有事物，并且传播属性不一样，A发生异常B怎么办   B异常了A咋呢么办？



required  

required_new 

nested 

support

not_support

nerver

mandatory
