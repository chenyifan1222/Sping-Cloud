package com.cloud.zookeeper.lock;

public abstract class AbstractZkLock implements Lock {
    //使用了模板方法，开放使用的只有getLock和unLock方法
    @Override
    public void getLock() {
        if (tryLock()) {
            System.out.println("获取锁");
        } else {
            //未获取到锁等待
            waitLock();
            //获取到锁之后，唤醒
            getLock();
        }
    }
 
    /**
     * ②占有锁
     *
     * @return 获取锁返回true
     */
    public abstract boolean tryLock();
 
    /**
     * 等待
     */
    public abstract void waitLock();
}