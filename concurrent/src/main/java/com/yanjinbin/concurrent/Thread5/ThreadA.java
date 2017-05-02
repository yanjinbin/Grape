package com.yanjinbin.concurrent.Thread5;

/**
 * Created by yanjinbin on 2017/5/2.
 */


// YieldTest.java的源码
class ThreadA extends Thread{
    public ThreadA(String name){
        super(name);
    }

    @Override
    public synchronized void run(){
        for(int i=0; i <14; i++){
            System.out.printf("name:\t %s \t priority:\t[%d]:%d\n", this.getName(), this.getPriority(), i);
            // i整除4时，调用yield
            if (i%4 == 0)
                Thread.yield();
        }
    }
}

