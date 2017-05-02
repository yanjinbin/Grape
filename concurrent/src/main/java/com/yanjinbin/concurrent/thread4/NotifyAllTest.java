package com.yanjinbin.concurrent.thread4;

/**
 * Created by yanjinbin on 2017/5/2.
 */
public class NotifyAllTest {
    private static Object obj = new Object();

    public static void main(String[] args) {


        /*
        try {
            obj.wait();
            System.out.println("obj wait again");
            obj.wait();
        }catch (InterruptedException ex){

        }*/

        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");

        t1.start();
        t2.start();
        t3.start();


        try {
            System.out.println(Thread.currentThread().getName() + "\tsleep(5000ms)");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + "notifyAll()");
            obj.notifyAll();

        }
        //5. 为什么notify(), wait()等函数定义在Object中，而不是Thread中


    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }


        @Override
        public void run() {
            synchronized (obj) {
                try {

                    System.out.println(Thread.currentThread().getName() + "\t\twait");

                    obj.wait();

                    System.out.println(Thread.currentThread().getName() + "\tcontinue");

                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
    }
}
