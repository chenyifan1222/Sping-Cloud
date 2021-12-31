package com.seata.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther chenyf
 * @date 2021年12月16日16:35
 */
public class BlockQueueDemo {

    public static void main(String[] args) throws Exception{
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(33);

        for (int i = 0; i < 5; i++) {
            int a = i;
            new Thread(() ->{
                try {
                    linkedBlockingQueue.put(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
        for (int i = 0; i < linkedBlockingQueue.size(); i++) {
            System.out.println(linkedBlockingQueue.take());
        }
    }
}
