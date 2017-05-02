package com.yanjinbin.concurrent.thread4;

/**
 * Created by yanjinbin on 2017/5/2.
 */
public class WaitTest1 {
    public static void main(String[] args) {
        ThreadA_1 t1 = new ThreadA_1("t1");

        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(5000);//等待5秒之后 进入就绪状态runnable()
                System.out.println(Thread.currentThread().getName() + " continue");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
