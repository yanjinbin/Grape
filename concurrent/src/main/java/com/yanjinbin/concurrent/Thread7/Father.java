package com.yanjinbin.concurrent.Thread7;

/**
 * Created by yanjinbin on 2017/5/2.
 */
public class Father extends Thread {
    @Override
    public void run() {
        try {
            Son s = new Son();
            s.start();
            s.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
