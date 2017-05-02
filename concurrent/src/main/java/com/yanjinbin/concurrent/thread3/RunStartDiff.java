package com.yanjinbin.concurrent.thread3;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class RunStartDiff {
    public static void main(String[] args) {
        // 展示区别 run() 和start()
        Thread mythread = new MyThread("mythread");

        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        //在主线程main 启动
        mythread.run();
        //创建一个mythread线程 启动run
        System.out.println(Thread.currentThread().getName() + " call mythread.start()");
        mythread.start();

    }
}

