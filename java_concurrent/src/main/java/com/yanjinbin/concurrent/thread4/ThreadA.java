package com.yanjinbin.concurrent.thread4;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class ThreadA extends Thread {

    public ThreadA(String name){
        super(name);
    }

    @Override
    public void run(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"is called notify");
            //唤醒当前线程
            notify();
        }
    }
}
