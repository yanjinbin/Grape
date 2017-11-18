package com.yanjinbin.concurrent.lock_category;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class CLHLock {

    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<CLHNode>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");
    private volatile CLHNode tail;

    public void lock() {
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            while (preNode.isLocked) {

            }

            preNode = null;
            LOCAL.set(node);
        }

    }

    public void unlock() {
        CLHNode node = LOCAL.get();
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }

    public static class CLHNode {
        private volatile boolean isLocked = true;
    }


}

