package com.yanjinbin.concurrent.consume_producer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://blog.csdn.net/u012228718/article/details/41652285#
 * <p>
 * <p>
 * 利用阻塞对了实现生产消费者模型
 * BlockingQueueTest.java
 *
 * @author SAM-SHO
 * @title 阻塞队列的运用
 * @description Q
 * 1-队列：数据的集合，先进先出。有固定大小的，也可以不固定。
 * 2-阻塞与非阻塞：可以阻塞也可以不阻塞。非阻塞的，会报错。阻塞的会阻塞。
 * 3、ArrayBlockingQueue实现了BlockingQueue接口。
 * 1）-Insert(放):add(e)-抛异常;offer(e)-返回true/false; put(e)-阻塞;
 * 2）-Remove(取)：remove()-抛异常; poll()-返回null; take()-阻塞; poll(time,unit)
 * @Date 2014-8-31
 */
public class ConsumeProduceTest {
    public static void main(String[] args) {
        // 定义一个阻塞队列，允许放三个数据
        final BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(3);

        // 两个子线程 放数据
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep((long) (Math.random() * 1000));
                            System.out.println(Thread.currentThread().getName() + "准备放数据!");
                            queue.put(1);// put()放的时候，会阻塞

                            // queue.size() 取到现在队列的大小
                            System.out.println(Thread.currentThread().getName() + "已经放了数据，" + "队列目前有" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }.start();
        }

        // main 主线程 取数据
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 将此处的睡眠时间分别改为100和1000，观察运行结果
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "准备取数据!");

                        queue.take();// 取数据
                        System.out.println(Thread.currentThread().getName() + "已经取走数据，" + "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
    }
}