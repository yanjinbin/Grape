package com.yanjinbin.concurrent.synchronize_keyword;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Count {

    // 同步方法

    public void sync() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " sync Method loop " + i);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //非同步方法
    public void nonSync() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonsync Method loop " + i);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
