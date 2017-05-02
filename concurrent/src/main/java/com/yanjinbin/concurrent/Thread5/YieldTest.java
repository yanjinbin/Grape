package com.yanjinbin.concurrent.Thread5;

/**
 * Created by yanjinbin on 2017/5/2.
 */


public class YieldTest{
    public static void main(String[] args){
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }
}
