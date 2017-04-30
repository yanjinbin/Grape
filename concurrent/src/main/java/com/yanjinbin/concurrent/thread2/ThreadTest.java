package com.yanjinbin.concurrent.thread2;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class ThreadTest {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);

        t1.start();
        t2.start();
        t3.start();
    }
}
