package com.yanjinbin.concurrent.interrupt_mechanism;

/**
 * http://www.infoq.com/cn/articles/java-interrupt-mechanism
 * http://wiki.jikexueyuan.com/project/java-concurrency/thread-interrupt.html
 * // 这篇文章 好好理解 就应该能清楚 线程中断机制 和 中断异常的跑出  中断标志位的关系
 * http://www.cnblogs.com/onlywujun/p/3565082.html
 *
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class ThreadInterruptTry {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        int a = 11;
        while (!Thread.currentThread().isInterrupted()) {
            if (a == 15) break;
            a++;
            System.out.println("哈哈");
        }
    }
}
