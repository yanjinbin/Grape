package com.yanjinbin.concurrent.lock_category;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 http://ifeve.com/java_lock_see1/
 * <p>
 * 自旋锁是采用让当前线程不停地的在循环体内执行实现的，当循环的条件被其他线程改变时 才能进入临界区
 *
 * @Author silver bullet
 * on ${Date}.
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
            //do nothing no-limit cycle ;
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}
