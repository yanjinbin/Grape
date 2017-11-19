package com.yanjinbin.concurrent;

import java.util.HashMap;

/**
 * http://blog.csdn.net/xuefeng0707/article/details/40797085
 * <p>
 * hash_map 在多线程环境下  rehashing 引发循环死锁情况分析
 * <p>
 * 这个在 jdk8下 代码已经做了修改了  !!!!
 *
 * @Author Silver bullet
 * @Since 2017/6/1.
 */
public class HashMapRehashIng {
    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2, 0.75F);

    public static void main(String[] args) {
        map.put(5, 55);
        Thread t1 = new Thread("Thread_1`") {
            @Override
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            }
        };
        t1.start();

        Thread t2 = new Thread("Thread_2") {
            @Override
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            }
        };
        t2.start();

    }
}
