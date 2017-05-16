package com.yanjinbin.concurrent.consume_producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://blog.csdn.net/u012228718/article/details/41652285#
 * <p>
 * BlockingQueueCommunication.java
 *
 * @author SAM-SHO
 * @title 阻塞队列实现同步通知
 * @description 1-阻塞队列与Semphore有些类似，但也不同，阻塞队列是一方存放数据，另一方释放数据
 * 2-Semphore通常是由同一方设置和释放信号量
 * @Date 2014-8-31
 */
public class BlockQueueCommunication {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final Business business = new Business();

        //子线程
        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 1; i <= 5; i++) {
                    business.sub(i);
                }

            }
        }).start();

        // 主线程
        for (int i = 1; i <= 10; i++) {//5次循环以后，会阻塞。因为子线程已经结束 queue2 没有线程去取
            business.main(i);
        }

    }

    // 内部类使用 static ，实现为外部类
    static class Business {

        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);//队列1
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);//队列2

        // 匿名构造方法，运行时机在任何构造方法之前
        {
//          Collections.synchronizedMap(null);// map的同步类方法
            try {
                System.out.println("xxxxxdfsdsafdsa");
                queue2.put(1);// 先在队列2 queue2中放数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * @param i
         */
        public void sub(int i) {
            try {
                queue1.put(1);//队列1 放数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("子线程 sequece of " + j + ",loop of " + i);
            }
            try {
                queue2.take();//队列2 取数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * @param i
         */
        public void main(int i) {
            try {
                queue2.put(1);//队列2 放数据，如果先主线程进来，会阻塞
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            for (int j = 1; j <= 4; j++) {
                System.out.println("主线程  sequece of " + j + ",loop of " + i);
            }
            try {
                queue1.take();// 队列1 取数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
