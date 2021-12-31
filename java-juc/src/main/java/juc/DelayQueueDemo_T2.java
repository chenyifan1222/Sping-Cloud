package juc;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @auther chenyf
 * @date 2021年12月30日18:28
 * 延迟队列
 */
public class DelayQueueDemo_T2 {

    public static void main(String[] args) {

        DelayQueue<DelayQueueTask> delayQueue = new DelayQueue<DelayQueueTask>();

        delayQueue.offer(new DelayQueueTask("100", 100));
        delayQueue.offer(new DelayQueueTask("101", 2001));
        delayQueue.offer(new DelayQueueTask("102", 300));
        delayQueue.offer(new DelayQueueTask("103", 400));
        delayQueue.offer(new DelayQueueTask("104", 5004));
        delayQueue.offer(new DelayQueueTask("105", 600));

        while (true){
            try {
                DelayQueueTask take = delayQueue.take();

                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DelayQueueTask implements Delayed {

        private String orderId;

        private long start = System.currentTimeMillis();

        private long time;

        @Override
        public String toString() {
            return "DelayQueueTask{" +
                    "orderId='" + orderId + '\'' +
                    ", start=" + start +
                    ", time=" + time +
                    '}';
        }

        public DelayQueueTask(String orderId, long time) {
            this.orderId = orderId;
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((time + start) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}
