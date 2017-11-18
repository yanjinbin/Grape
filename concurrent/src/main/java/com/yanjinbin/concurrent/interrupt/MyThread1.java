package com.yanjinbin.concurrent.interrupt;

/**
 * Created by yanjinbin on 2017/5/2.
 */

// Demo1.java的源码
class MyThread1 extends Thread {

    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100); // 休眠100ms
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
        }
    }
}
