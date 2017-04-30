package com.yanjinbin.concurrent.thread2;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class MyThread implements Runnable {

    private Integer ticket=100;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            if (this.ticket > 0) {
                System.out.println("---" + Thread.currentThread().getName() + "卖票----" + this.ticket--);
            }
        }
    }
}
