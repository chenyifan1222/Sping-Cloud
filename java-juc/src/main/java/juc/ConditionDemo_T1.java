package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther chenyf
 * @date 2021年12月30日13:01
 */
public class ConditionDemo_T1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionAwait conditionAwait = new ConditionAwait(lock, condition);
        ConditionSignal ConditionSignal = new ConditionSignal(lock, condition);

        new Thread(conditionAwait).start();
        new Thread(ConditionSignal).start();

    }

    static class ConditionAwait implements Runnable{

        Lock lock;
        Condition condition;

        public ConditionAwait(Lock lock, Condition condition) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {

            lock.lock();   //synchroized

            System.out.println(Thread.currentThread().getName() + " 1 begin");

            try {

                condition.await();

                System.out.println(Thread.currentThread().getName() + " 1 end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class ConditionSignal implements Runnable{

        Lock lock;
        Condition condition;

        public ConditionSignal(Lock lock, Condition condition) {
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {

            lock.lock();   //synchroized

            System.out.println(Thread.currentThread().getName() + "2  begin");

            try {

                condition.signal();

                System.out.println(Thread.currentThread().getName() + "2  end");

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
