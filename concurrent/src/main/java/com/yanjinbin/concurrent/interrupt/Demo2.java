package com.yanjinbin.concurrent.interrupt;

/**
 * @Author Silver bullet
 * @Since 2017/5/15.
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            MyThread2 t2 = new MyThread2("t2");
            System.out.println(t2.getName() + " (" + t2.getState() + ") is new.");

            t2.start();
            System.out.println(t2.getName() + " (" + t2.getState() + ") is started.");

            //  Thread.sleep(300);
            System.out.println(t2.interrupted());
            System.out.println(t2.isInterrupted());
            t2.interrupt();
            System.out.println("interrupted twice \t here ");
            System.out.println(t2.interrupted());
            System.out.println(t2.isInterrupted());


            System.out.println(t2.getName() + " (" + t2.getState() + ") is interrupted.");


            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t2.getName() + " (" + t2.getState() + ") is interrupted now.");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
