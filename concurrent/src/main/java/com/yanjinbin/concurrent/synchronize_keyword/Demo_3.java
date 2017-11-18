package com.yanjinbin.concurrent.synchronize_keyword;


/**
 * Created by yanjinbin on 2017/4/30.
 */
public class Demo_3 {
    public static void main(String[] args) {
        final Count_3 count3 = new Count_3();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count3.sync();
                    }
                }
        );

        // 当一个线程访问该对象的同步方法，获取同步锁的时候， 其他线程依旧可以获取非同步方法
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count3.sync_1();
            }
        });


        t1.start();
        //t2被阻塞  那么 会等待t1走完之后再执行 而不是什么都不做
        t2.start();
    }
}
