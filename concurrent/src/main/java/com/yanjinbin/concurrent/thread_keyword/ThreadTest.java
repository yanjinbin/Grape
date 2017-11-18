package com.yanjinbin.concurrent.thread_keyword;

/**
 * 同等级之间thread 的相互竞争
 * Created by yanjinbin on 2017/4/29.
 */
public class ThreadTest {
    public static void main(String[] args) {

        // http://www.cnblogs.com/skywang12345/p/3479024.html

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
