package com.yanjinbin.concurrent.lock_category.reentrant_lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * http://ifeve.com/java_lock_see4/
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class SpinLock1 {
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    private int count = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            count++;
            return;
        }

        while (!owner.compareAndSet(null, current)) {

        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (count != 0) {
                count--;
            } else {
                owner.compareAndSet(current, null);
            }

        }

    }


}