package com.yanjinbin.concurrent.synchronize;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Demo1_1 {
    public static void main(String[] args) {
        Runnable demo = new MyRunabble();
        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");
        //两者也是有区别
//        Thread t1 = new Thread(new MyRunabble(), "t1");
//        Thread t2 = new Thread(new MyRunabble(), "t2");
        t1.start();
        t2.start();
    }
}
