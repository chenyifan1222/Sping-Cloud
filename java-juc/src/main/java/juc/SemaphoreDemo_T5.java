package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @auther chenyf
 * @date 2022年03月01日14:36
 * 信号量主要用于两个目的
 * <p>
 * 一个是用于共享资源的互斥使用
 * 另一个用于并发线程数的控制
 * <p>
 * 我们模拟一个抢车位的场景，假设一共有6个车，3个停车位
 */
public class SemaphoreDemo_T5 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, false);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();  // 代表一辆车，已经占用了该车位
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");

                    TimeUnit.SECONDS.sleep(3);

                    System.out.println(Thread.currentThread().getName() + "\t 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();  // 释放停车位
                }

            }, String.valueOf(i)).start();
        }
    }
}
