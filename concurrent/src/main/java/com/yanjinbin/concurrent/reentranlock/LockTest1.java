package com.yanjinbin.concurrent.reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanjinbin on 2017/5/3.
 */
public class LockTest1 {
    public static void main(String[] args) {
        Depot_2 mDepot2 = new Depot_2();
        Producer_2 mPro = new Producer_2(mDepot2);
        Customer_2 mCus = new Customer_2(mDepot2);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);


    }


}

class Depot {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot() {
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
};

// 生产者
class Producer {

    private Depot_2 depot2;

    public Producer(Depot_2 depot2) {
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
class Customer {
    private Depot_2 depot2;

    public Customer(Depot_2 depot2) {
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


