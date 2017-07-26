package com.yanjinbin.concurrent.interrupt_mechanism;

/**
 * http://www.infoq.com/cn/articles/java-interrupt-mechanism
 * http://wiki.jikexueyuan.com/project/java-concurrency/thread-interrupt.html
 * // 这篇文章 好好理解 就应该能清楚 线程中断机制 和 中断异常的跑出  中断标志位的关系
 * http://www.cnblogs.com/onlywujun/p/3565082.html
 * 也就是说interrupted() 如果已经是true 那么返回True的同时还清楚true ，变成false
 * 如果是false 则继续false
 *
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class ThreadInterruptTry {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
      //  Thread.currentThread().interrupt();
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
