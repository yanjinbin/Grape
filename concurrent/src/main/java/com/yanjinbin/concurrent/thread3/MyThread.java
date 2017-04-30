package com.yanjinbin.concurrent.thread3;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动了--");
    }
}
