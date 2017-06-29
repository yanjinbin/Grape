package com.yanjinbin.concurrent.synchronize_keyword;

/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Demo_2 {
    public static void main(String[] args) {
        final Count count = new Count();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.sync();
                    }
                }
        );

        // 当一个线程访问该对象的同步方法，获取同步锁的时候， 其他线程依旧可以获取非同步方法
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.nonSync();
            }
        });


        t1.start();
        t2.start();
    }
}
