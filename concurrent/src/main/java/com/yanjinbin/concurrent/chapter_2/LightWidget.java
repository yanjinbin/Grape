package com.yanjinbin.concurrent.chapter_2;

/**
 * @Author Silver bullet
 * @Since 2017/7/3.
 */
public class LightWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        System.out.println("super is doing something");
        super.doSomething();
        System.out.println("then LightWidget will do something");
    }
}
