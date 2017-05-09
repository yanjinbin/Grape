package com.yanjinbin.concurrent.lock_category.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class Test_2 implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Test_2 ss = new Test_2();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}