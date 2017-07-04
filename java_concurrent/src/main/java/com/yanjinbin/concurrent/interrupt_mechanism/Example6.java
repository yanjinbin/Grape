package com.yanjinbin.concurrent.interrupt_mechanism;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 展示了 阻塞 IO 通过 close()方法可以 来终端
 *
 * @Author Grape
 * @Since 2017/7/4.
 */
public class Example6 extends Thread {

    volatile ServerSocket serverSocket;

    public static void main(String[] args) throws InterruptedException, IOException {
        Example6 example6 = new Example6();
        System.out.println("starting thread");
        example6.start();
        Thread.sleep(3000);
        System.out.println("asking thread to stop");
        Thread.currentThread().interrupt();
        example6.serverSocket.close();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("enter interrupt routine");
        }
        System.out.println("stopping application");
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println("---- connection is interrupt ----");
            e.printStackTrace();
            return;
        }

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("---- waiting for connection ----");
            try {
                serverSocket.accept();
            } catch (IOException e) {
                // e.printStackTrace();
                System.out.println("accept() failed or interrupted...");
                Thread.currentThread().interrupt();//重新设置中断标示位
            }
        }
        System.out.println("Thread exiting under request...");

    }
}
