# **AQS**(AbstractQueuedSynchronizer抽象队列同步器简称AQS)

**(1)**AQS是一个通过内置的**FIFO**双向队列来完成线程的排队工作(内部通过结点head和tail记录队首和队尾元素，元素的结点类型为Node类型，后面我们会看到Node的具体构造)。

**AQS的核心思想**：如果被请求的共享资源空闲，则将当前请求的资源的线程设置为有效的工作线程，并将共享资源设置为锁定状态，如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及唤醒时锁分配的机制，这个AQS是用CLH队列锁实现的，即将暂时获取不到的锁的线程加入到队列中。CLH队列是一个虚拟的双向队列，虚拟的双向队列即不存在队列的实例，仅存在节点之间的关联关系。









## ReentrantLock

公平锁跟非公平锁  默认非公平锁  是独占锁也就是当前持有锁的只能有一个线程



## ReentrantReadWiterLock  

读写所读锁可多个，写锁只有一个



```
CountDownLatch
概念：让一些线程阻塞直到另一些线程完成一系列操作才被唤醒

CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，调用线程就会被阻塞。其它线程调用CountDown方法会将计数器减1（调用CountDown方法的线程不会被阻塞），当计数器的值变成零时，因调用await方法被阻塞的线程会被唤醒，继续执行

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }
}
```

 

```/**
CyclicBarrier

概念：和CountDownLatch相反，需要集齐七颗龙珠，召唤神龙。也就是做加法，开始是0，加到某个值的时候就执行

CyclicBarrier的字面意思就是可循环（cyclic）使用的屏障（Barrier）。它要求做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await方法



/**
 * @author chenyf
 * @date 2021/11/18 14:33
*/
public class CyclicBarrierDemo {


    public static void main(String[] args) {
        /**
         * 定义一个循环屏障，参数1：需要累加的值，参数2 需要执行的方法
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final Integer tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到 第" + tempInt + "颗龙珠");

                try {
                    // 先到的被阻塞，等全部线程完成后，才能执行方法
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

```




    Semaphore：信号量
    
    概念：信号量主要用于两个目的
    
    一个是用于共享资源的互斥使用
    另一个用于并发线程数的控制
    
    package com.kavin.oauth.lock;
    
    import java.util.concurrent.Semaphore;
    import java.util.concurrent.TimeUnit;
    
    /**
     * @auther chenyf
     * @date 2021年11月18日14:24
     */
    public class SemaphoreDemo {
    
        public static void main(String[] args) {
            /**
             * 初始化一个信号量为3，默认是false 非公平锁， 模拟3个停车位
             */
            Semaphore semaphore = new Semaphore(3, false);
    
            for (int i = 0; i < 6; i++) {
                new Thread(() ->{
                    try {
                        // 代表一辆车，已经占用了该车位
                        semaphore.acquire(); // 抢占
                        System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
    
                        // 每个车停3秒
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "\t 离开车位");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // 释放停车位
                        semaphore.release();
                    }
                }, String.valueOf(i)).start();
            }
        }
    }
    3	 抢到车位
    5	 抢到车位
    4	 抢到车位
    5	 离开车位
    3	 离开车位
    4	 离开车位
    2	 抢到车位
    0	 抢到车位
    1	 抢到车位
    0	 离开车位
    1	 离开车位
    2	 离开车位

