package com.yanjinbin.concurrent.reentranlock;

/**
 * Created by yanjinbin on 2017/5/3.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Depot_2 {
    private int actual_size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot_2() {
        this.actual_size = 0;
        this.lock = new ReentrantLock();// 可以重入的锁
    }

    public void produce(int val) {

        actual_size += val;
        System.out.printf("%s produce(%d) --> actual_size=%d\n",
                Thread.currentThread().getName(), val, actual_size);

    }

    public void consume(int val) {
        actual_size -= val;
        System.out.printf("%s consume(%d) <-- actual_size=%d\n",
                Thread.currentThread().getName(), val, actual_size);
    }
}

// 生产者
class Producer_2 {
    private Depot_2 depot2;

    public Producer_2(Depot_2 depot2) {
        this.depot2 = depot2;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot2.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer_2 {
    private Depot_2 depot2;

    public Customer_2(Depot_2 depot2) {
        this.depot2 = depot2;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot2.consume(val);
            }
        }.start();
    }
}

public class LockTest2 {
    public static void main(String[] args) {
        Depot_2 mDepot2 = new Depot_2();
        Producer_2 mPro = new Producer_2(mDepot2);
        Customer_2 mCus = new Customer_2(mDepot2);

        // 没有加锁的情况下
        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
      //   110+120+60-90-150 = 50 （实际是180） 与实际情况相反



    }
}
