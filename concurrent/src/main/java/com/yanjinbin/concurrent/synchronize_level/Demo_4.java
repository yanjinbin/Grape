package com.yanjinbin.concurrent.synchronize_level;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Demo_4 {

    Something x = new Something();
    Something y = new Something();


    public static void main(String[] args) {
        Demo_4 demo_4 = new Demo_4();
         // demo_4.test1();

      // demo_4.test2();
       // demo_4.test3();
       demo_4.test4();

    }

    public void test1() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncA();
            }
        });
        // 线程阻塞了啊


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncB();
            }
        });

        t1.start();
        t2.start();
    }

    public void test2() {
        // x y获取的2个对象上的锁  不会造成各自阻塞


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncA();
            }
        });
        // 线程阻塞了啊


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.syncA();
            }
        });

        t1.start();
        t2.start();
    }

    public void test3() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Something.cSyncC();
            }
        });
        // 线程阻塞了啊

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Something.cSyncD();
            }
        });

        t1.start();
        t2.start();
    }


    public void test4(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Something.cSyncD();
            }
        });

        t1.start();
        t2.start();
    }


}
