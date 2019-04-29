package com.yanjinbin.concurrent;

import java.util.concurrent.DelayQueue;

// 并发队列-无界阻塞延迟队列DelayQueue原理探究
// https://dwz.cn/213aebtg
// https://dwz.cn/sZtfa1cb
// https://www.zybuluo.com/mikumikulch/note/712598
public class DelayQueueTry {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();

        DelayedEle element1 = new DelayedEle(1090, "zlx");
        DelayedEle element2 = new DelayedEle(1000, "gh");

        delayQueue.offer(element1);
        delayQueue.offer(element2);

        element1 = delayQueue.take();
        System.out.println(element1);

    }

}
