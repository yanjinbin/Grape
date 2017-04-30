package com.yanjinbin.concurrent.synchronize_1;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "\tloop\t" + i + "\thashcode\t" + this.hashCode());
                }

            } catch (InterruptedException ex) {

            }
        }
    }
}
