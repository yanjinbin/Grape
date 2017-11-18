package com.yanjinbin.concurrent.AtomicOperation;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by yanjinbin on 2017/5/2.
 */
public class MyLock {

    private volatile boolean locked = false;
    private AtomicBoolean lock = new AtomicBoolean(false);

    //Atomic package 来实现原子性

    // JUC 是 建立在CAS基础之上的

    //加了synchronized 说明在任意时刻 只有一个线程在执行check and act操作
    public synchronized boolean lock() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    public boolean locked() {
        return lock.compareAndSet(false, true);
    }

}
