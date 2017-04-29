package com.yanjinbin.concurrent.thread1;

import com.yanjinbin.concurrent.MyThread;

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


//        Thread t1 = new Thread(mt);
//        Thread t2 = new Thread(mt);
//        Thread t3 = new Thread(mt);
//        t1.start();
//        t2.start();
//        t3.start();


    }
}
