package com.yanjinbin.concurrent.thread1;

/**
 * Created by yanjinbin on 2017/4/29.
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();



    }
}
