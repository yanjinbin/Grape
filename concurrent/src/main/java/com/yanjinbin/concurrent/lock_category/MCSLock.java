package com.yanjinbin.concurrent.lock_category;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * http://ifeve.com/java_lock_see2/
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */

//CLHlock是不停的查询前驱变量， 导致不适合在NUMA 架构下使用（在这种结构下，每个线程分布在不同的物理内存区域）
//
//        MCSLock则是对本地变量的节点进行循环。不存在CLHlock 的问题

public class MCSLock {
    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<MCSNode>();
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class,
            MCSNode.class, "queue");
    private volatile MCSNode queue;

    public void lock() {
        MCSNode currentNode = new MCSNode();
        NODE.set(currentNode);
        MCSNode preNode = UPDATER.getAndSet(this, currentNode);
        if (preNode != null) {
            preNode.next = currentNode;
            while (currentNode.isLocked) {

            }
        }
    }

    public void unlock() {
        MCSNode currentNode = NODE.get();
        if (currentNode.next == null) {
            if (UPDATER.compareAndSet(this, currentNode, null)) {

            } else {
                while (currentNode.next == null) {
                }
            }
        } else {
            currentNode.next.isLocked = false;
            currentNode.next = null;
        }
    }

    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isLocked = true;
    }
}