package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther chenyf
 * @date 2021年12月28日16:13
 */
public class Aqs_ReentranLocal_T1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);

        reentrantLock.lock();

        for (int i = 0; i < 2; i++) {
            System.out.println("Aqs_ReentranLocal_T1");
        }

        reentrantLock.unlock();
    }
}
