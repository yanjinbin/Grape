package com.yanjinbin.concurrent.DeadLock;

/**
 * 需要好好理解 锁和线程 对象 类 之间的关系
 *
 * @Author Grape
 * @Since 2017/7/4.
 */
public class Example4 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        final Object o1 = new Object();
        final Object o2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deathLock(o1, o2);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deathLock(o2, o1);
            }
        });
        System.out.println("starting thread----");
        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println("interrupting thread");
        t1.interrupt();
        t2.interrupt();
        Thread.sleep(3000);
        System.out.println("stop application");
    }

    private static void deathLock(Object o1, Object o2) {
        try {
            synchronized (o1) {
                Thread.sleep(10);// 不会在这里死掉
                synchronized (o2) {// 会锁在这里，虽然阻塞了，但不会抛异常
                    System.out.println(Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
