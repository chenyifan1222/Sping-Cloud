package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther chenyf
 * @date 2022年03月01日16:11
 */
public class ReentrantLockDemo_T6 {
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(false);

        reentrantLock.lock();

        System.out.println(123);

        reentrantLock.unlock();
    }
}
