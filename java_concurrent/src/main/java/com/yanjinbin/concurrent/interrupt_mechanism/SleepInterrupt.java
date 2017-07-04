package com.yanjinbin.concurrent.interrupt_mechanism;

/**
 * @Author Silver bullet
 * @Since 2017/7/3.
 */
public class SleepInterrupt implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("in run 20 second sleep");
            Thread.sleep(20000);
            System.out.println("in run wakeup()");

        } catch (InterruptedException e) {
            System.out.println("interuptted :\t"+(Thread.currentThread().isInterrupted()));
            System.out.println("in run interrupted while sleeping()");
            e.printStackTrace();
            return;
        }
        System.out.println(" in run ()  leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread thread = new Thread(si);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main() - interrupting other thread");
        //中断线程t
        thread.interrupt();
        System.out.println("in main() - leaving");
    }
}
