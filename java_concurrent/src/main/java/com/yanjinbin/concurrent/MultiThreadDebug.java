package com.yanjinbin.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * idea 多线程调试
 * http://dwz.cn/6g4gkZ
 *
 * @Author Grape
 * @Since 2017/7/6.
 */
public class MultiThreadDebug {
    public static void main(String[] args) throws InterruptedException {
        int i = atomicInteger.get();
        System.out.println(i);

        // 多线程名字一定要取好,这样才能调试的时候 方便切换线程d

        Thread t = new Thread("---哈哈--") { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {// 调试的时候 切换线程 你需要慢点

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
                for (int j = 0; j < 10; j++) {
                    System.out.println("j 的值\t"+j);
                }
            }
        };
        t.start();


        // 外线程
        System.out.println("3"); // 断点3
        Thread.sleep(2000);
        System.out.println("4"); // 断点4


    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
}
