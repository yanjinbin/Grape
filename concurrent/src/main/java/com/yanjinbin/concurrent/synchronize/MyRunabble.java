package com.yanjinbin.concurrent.synchronize;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class MyRunabble implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"\tloop\t"+i);
                }
                
            }catch (InterruptedException ex){

            }
        }
    }
}
