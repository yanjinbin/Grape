package com.yanjinbin.concurrent.run_start_diff;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动了--");
    }
}
