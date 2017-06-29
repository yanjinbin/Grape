package com.yanjinbin.concurrent.lock_category;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/**
 * 从CLHLock 修改而来
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class BlockLock {

    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<CLHNode>();
    private static final AtomicReferenceFieldUpdater<BlockLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(BlockLock.class, CLHNode.class, "tail");
    private volatile CLHNode tail;

    public void lock() {
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            //之前节点存在一个线程
            preNode.isLocked = Thread.currentThread();
            LockSupport.park(this);
            preNode = null;
            LOCAL.set(node);
        }

    }

    public void unlock() {
        CLHNode node = LOCAL.get();
        if (UPDATER.compareAndSet(this, node, null)) {
            System.out.println("unlock\t" + node.isLocked.getName());
            LockSupport.unpark(node.isLocked);
        }
    }

    private static class CLHNode {
        private volatile Thread isLocked;
    }

    //在这里我们使用了LockSupport.unlock()的阻塞锁。 该例子是将CLH锁修改而成。

//    阻塞锁的优势在于，阻塞的线程不会占用cpu时间， 不会导致 CPu占用率过高，但进入时间以及恢复时间都要比自旋锁略慢。
//
//    在竞争激烈的情况下 阻塞锁的性能要明显高于 自旋锁。
//
//    理想的情况则是; 在线程竞争不激烈的情况下，使用自旋锁，竞争激烈的情况下使用，阻塞锁
}
