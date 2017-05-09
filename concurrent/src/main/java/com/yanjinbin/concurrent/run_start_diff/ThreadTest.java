package com.yanjinbin.concurrent.run_start_diff;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
//        t1.start();
//        System.out.println("start again");
//        t1.start();// 抛异常  java.lang.IllegalThreadStateException


        //同样的线程
        t1.run();
        System.out.println("run again");
        t1.run();

    }
}
