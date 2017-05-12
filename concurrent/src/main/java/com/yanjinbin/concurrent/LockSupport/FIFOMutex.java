package com.yanjinbin.concurrent.LockSupport;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * http://blog.csdn.net/wojiaolinaaa/article/details/50016515
 *
 * @Author Silver bullet
 * @Since 2017/5/12.
 */
public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);

    private final Queue<Thread> waiters = new ConcurrentLinkedQueue();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        // 获取当前线程,放入Queued队列头部实现 First in First Out
        waiters.add(current);

        //Block while not first in queue    or    can not acquire lock
        // locked 是 true和waiter head不是current时候 执行while循环体内code block
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted) {
            current.interrupt();
        }

    }

    public void unlock() {
        locked.set(false);
        //需要自习看下
        LockSupport.unpark(waiters.peek());
    }
}




