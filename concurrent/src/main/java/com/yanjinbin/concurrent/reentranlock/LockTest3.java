package com.yanjinbin.concurrent.reentranlock;

/**
 * Created by yanjinbin on 2017/5/3.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Depot_3 {
    private int capacity;    // 仓库的容量
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁
    private Condition fullCondtion;            // 生产条件
    private Condition emptyCondtion;        // 消费条件

    public Depot_3(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.fullCondtion = lock.newCondition();
        this.emptyCondtion = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        try {
            // left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (size >= capacity)
                    fullCondtion.await();
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                emptyCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            // left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
            int left = val;
            while (left > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (size <= 0)
                    emptyCondtion.await();
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                fullCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return "capacity:" + capacity + ", actual size:" + size;
    }
};

// 生产者
class Producer_3 {
    private Depot_3 depot3;

    public Producer_3(Depot_3 depot3) {
        this.depot3 = depot3;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot3.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer_3 {
    private Depot_3 depot3;

    public Customer_3(Depot_3 depot3) {
        this.depot3 = depot3;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot3.consume(val);
            }
        }.start();
    }
}

public class LockTest3 {
    public static void main(String[] args) {
        Depot_3 mDepot3 = new Depot_3(100);
        Producer_3 mPro = new Producer_3(mDepot3);
        Customer_3 mCus = new Customer_3(mDepot3);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
