package com.yanjinbin.aop;

public class Singleton {
    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.instance());
    }


    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public final static Singleton instance() {
        return SingletonHolder.INSTANCE;
    }
}
