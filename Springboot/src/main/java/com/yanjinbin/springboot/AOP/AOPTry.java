package com.yanjinbin.springboot.AOP;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
public class AOPTry {

    public static void callAndExcuDiff(Integer i) {
        System.out.println("方法被调用");
        System.out.println("i的值   " + i);
    }


    public static void main(String[] args) {
        callAndExcuDiff(1);
    }
}
