package com.yanjinbin.concurrent.interrupt_mechanism;

import java.time.LocalDateTime;

/**
 * @Author Grape
 * @Since 2017/7/4.
 */
public class Example extends Thread {
    volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Example example = new Example();
        System.out.println("thread starting");
        System.out.println("1\t" + LocalDateTime.now());
        example.start();
        Thread.sleep(3);
        System.out.println("2\t" + LocalDateTime.now());
        System.out.println("asking thread to stop ");
        stopThread();
        Thread.sleep(3);

        System.out.println("3\t" + LocalDateTime.now());
        System.out.println("stop application");


    }

    public static void stopThread() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running ");
        }
    }
}
