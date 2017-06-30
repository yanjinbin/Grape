package com.yanjinbin.concurrent.chapter_3;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    public static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println("number：\t" + number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        // 指令重排序
        number = 42;
        ready = true;
    }

}
