package com.yanjinbin.concurrent.lock_category.reentrant_lock;

/**
 * http://ifeve.com/java_lock_see4/
 * 可重入锁也叫做递归锁
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class Test_1 implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Test_1 ss = new Test_1();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
