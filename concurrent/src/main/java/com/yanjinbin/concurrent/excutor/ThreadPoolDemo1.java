package com.yanjinbin.concurrent.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.cnblogs.com/skywang12345/p/3509954.html
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = new Mythread();
        Thread t2 = new Mythread();
        Thread t3 = new Mythread();
        Thread t4 = new Mythread();
        Thread t5 = new Mythread();
        Thread t6 = new Mythread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        pool.shutdown();
    }
}


class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is Running()");
    }
}