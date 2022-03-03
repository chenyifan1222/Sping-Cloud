package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @auther chenyf
 * @date 2022年03月01日14:17
 *
 * 让一些线程阻塞直到另一些线程完成一系列操作才被唤醒
 */
public class CountDownLatchDemo_T3 {

    public static void main(String[] args) throws InterruptedException {
        //计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                //countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        //countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }
}
