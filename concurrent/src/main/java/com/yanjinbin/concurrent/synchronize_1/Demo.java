package com.yanjinbin.concurrent.synchronize_1;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");

        t1.start();
        t2.start();

    }
}