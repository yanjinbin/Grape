package com.yanjinbin.concurrent.thread4;


/**
 * Created by yanjinbin on 2017/5/2.
 */
public class ThreadA_1 extends Thread {
    public ThreadA_1(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " run ");
        // 死循环，不断运行。
        while (true)
            System.out.println(Thread.currentThread().getName() + "" +
                    "\t我一直在运行噢");
    }

}
