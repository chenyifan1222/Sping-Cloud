# hystrix

1.降级

问题：

兜底方法导致代码膨胀

每次都加一个方法，需要统一跟自定义分开

怎么解决： 需要个全局的 galo

2.熔断

过程 ： 先降级 ---》  熔断-----》   恢复链路



![image-20211128182317529](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211128182317529.png)







![image-20211128182808686](C:\Users\MSI\AppData\Roaming\Typora\typora-user-images\image-20211128182808686.png)



3.限流

