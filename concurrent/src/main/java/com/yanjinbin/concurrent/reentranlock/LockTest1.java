package com.yanjinbin.concurrent.reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanjinbin on 2017/5/3.
 */
public class LockTest1 {
    public static void main(String[] args) {
        Depot_1 mDepot1 = new Depot_1();
        Producer_1 mPro = new Producer_1(mDepot1);
        Customer_1 mCus = new Customer_1(mDepot1);

        mPro.produce(60);

        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);


    }


}

class Depot_1 {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot_1() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();//锁住
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();//解锁
        }
    }
}

// 生产者
class Producer_1 {

    private Depot_1 depot1;

    public Producer_1(Depot_1 depot1) {
        this.depot1 = depot1;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot1.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer_1 {
    private Depot_1 depot_1;

    public Customer_1(Depot_1 depot_1) {
        this.depot_1 = depot_1;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot_1.consume(val);
            }
        }.start();
    }
}


