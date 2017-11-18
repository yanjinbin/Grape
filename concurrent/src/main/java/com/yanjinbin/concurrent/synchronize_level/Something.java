package com.yanjinbin.concurrent.synchronize_level;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Something {
    public static synchronized void cSyncC() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : cSyncC");
            }
        } catch (InterruptedException ie) {

        }

    }

    public static synchronized void cSyncD() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : cSyncD");
            }
        } catch (InterruptedException ie) {

        }

    }

    public synchronized void syncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : SyncA");
            }
        } catch (InterruptedException ie) {

        }
    }

    public synchronized void syncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : SyncB");
            }
        } catch (InterruptedException ie) {

        }
    }
}
