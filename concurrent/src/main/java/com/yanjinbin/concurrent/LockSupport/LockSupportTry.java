package com.yanjinbin.concurrent.LockSupport;


import java.time.LocalDateTime;
import java.util.concurrent.locks.LockSupport;

/**
 * 查看LockSupport 这个类  你会发现这其实是个工具类,大都是静态方法
 * 底层调用Unsafe 来实现atomic
 * http://www.cnblogs.com/daxin/p/3831403.html
 * <p>
 * http://blog.csdn.net/aesop_wubo/article/details/7537278
 * <p>
 * http://blog.csdn.net/wojiaolinaaa/article/details/50016515
 *
 * @Author Silver bullet
 * @Since 2017/5/12.
 */
public class LockSupportTry {
    private static FIFOMutex mutex = new FIFOMutex();

    public static void main(String[] args) {

        final Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        Thread thread = new Thread(() -> {
            System.out.println(LocalDateTime.now());
            System.out.println("5s之后解说主线程");
            try {
                Thread.sleep(5000);
                System.out.println(LocalDateTime.now());
                System.out.println(Thread.currentThread().getName() + "启动了鸟");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(mainThread);
        });
        thread.run();// thread.start()区别 一个新建线程 一个在当前线程启动
        LockSupport.parkUntil(3000);
        System.out.println("LockSupport has finished ");



        new Thread(() -> {
            try {
                Thread.sleep(1000 * 2);
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "\t准备lock_A");
                mutex.lock();
                System.out.println(threadName + "\t完成lock_A");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "\t准备lock_B");
            mutex.lock();
            System.out.println(threadName + "\t完成lock_B");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "\t准备unlock_C");
            mutex.unlock();
            System.out.println(threadName + "\t完成unlock_C");
        }).start();


    }
}
