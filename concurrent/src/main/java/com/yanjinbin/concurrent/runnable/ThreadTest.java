package com.yanjinbin.concurrent.runnable;

/**
 * MyThread 实现runnable 接口 之后的区别
 * Created by yanjinbin on 2017/4/30.
 */
public class ThreadTest {
    public static void main(String[] args) {
        //加了synchronized 关键字之后的 线程之间的关系
        MyThread mt = new MyThread();
        // 同一个线程
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);

        t1.start();
        t2.start();
        t3.start();
    }
}
