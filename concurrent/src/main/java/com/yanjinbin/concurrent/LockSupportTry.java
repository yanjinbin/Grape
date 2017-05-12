package com.yanjinbin.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.locks.LockSupport;

/**
 * 查看LockSupport 这个类  你会发现这其实是个工具类,大都是静态方法
 * 底层调用Unsafe 来实现atomic
 * http://www.cnblogs.com/daxin/p/3831403.html
 * <p>
 * http://blog.csdn.net/aesop_wubo/article/details/7537278
 *
 * @Author Silver bullet
 * @Since 2017/5/12.
 */
public class LockSupportTry {
    public static void main(String[] args) {
        final Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
            }
        });
        thread.run();// thread.start()区别 一个新疆县城 一个在当前线程启动
        LockSupport.park();
        System.out.println("LockSupport has finished ");


    }
}
