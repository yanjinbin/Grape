package com.yanjinbin.concurrent;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class Node {

    static final Node SHARED = new Node();

    static final Node EXCLUSICE = null;

    static final int CANCELLED = 1;

    static final int SIGNAL = -1;

    static final int CONDITION = -2;

    static final int PROPAGATE = -3;

    volatile int waitStatus;

    volatile Node prev;

    volatile Node next;

    volatile Thread thread;

    Node nextWaiter;

    final Node predecessor() throws NullPointerException {

        Node p = prev;

        if (p == null) {
            throw new NullPointerException();
        } else {
            return p;
        }
    }

    Node() {

    }

    Node(Thread thread, Node mode) {
        this.nextWaiter = mode;
        this.thread = thread;
    }

    Node(Thread thread, int waitStatus) {
        this.thread = thread;
        this.waitStatus = waitStatus;
    }

    final boolean isShared() {
        return nextWaiter == SHARED;
    }

}