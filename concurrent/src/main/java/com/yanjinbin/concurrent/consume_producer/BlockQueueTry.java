package com.yanjinbin.concurrent.consume_producer;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * http://blog.csdn.net/u012228718/article/details/41652285
 * http://www.cnblogs.com/it-science/p/5721104.html
 * http://www.cnblogs.com/skywang12345/p/3503480.html
 * <p>
 * ArrayBlockQueue 数组有界 FiFO
 * LinkedBlockQueue 链表有界 FIFO
 * LinkedBlockDeque 双向链表 同时支持 FIFO FILO 两种操作方式
 * <p>
 * 利用阻塞队列来实现生产和消费者模型
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class BlockQueueTry {
    //  queue是LinkedList对象时，程序会出错。 Fail-fast 机制

    // private static Queue<String> queue = new LinkedList<String>();
    // private static Queue<String> queue = new ArrayBlockingQueue<String>(20);
    private static Queue<String> queue = new LinkedBlockingQueue<String>(20);
    //private static Queue<String> queue = new LinkedBlockingDeque<String>(20);

    public static void main(String[] args) {

        // 同时启动两个线程对queue进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + i;
                queue.add(val);
                // 通过“Iterator”遍历queue。
                printAll();
            }
        }
    }
}

