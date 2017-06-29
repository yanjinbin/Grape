package com.yanjinbin.concurrent.interrupt;

/**
 * @Author Silver bullet
 * @Since 2017/5/15.
 */
public class MyThread2 extends Thread {

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("do anything here ");
//        while (!isInterrupted()) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
//            }
        i++;
        System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);

//        }
    }
}
