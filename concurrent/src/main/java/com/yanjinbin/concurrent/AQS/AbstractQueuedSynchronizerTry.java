package com.yanjinbin.concurrent.AQS;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * http://www.infoq.com/cn/articles/jdk1.8-abstractqueuedsynchronizer
 * http://www.infoq.com/cn/articles/java8-abstractqueuedsynchronizer
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html
 * http://ifeve.com/introduce-abstractqueuedsynchronizer/
 * http://www.cnblogs.com/zhanjindong/p/java-concurrent-package-aqs-AbstractQueuedSynchronizer.html
 * http://www.cnblogs.com/go2sea/p/5618628.html
 * http://www.cs.rochester.edu/wcms/research/systems/high_performance_synch/
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class AbstractQueuedSynchronizerTry extends AbstractOwnableSynchronizer {
    //
    static final long spinForTimeoutThreshold = 1000L;
    private static final Unsafe unSafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    // field
    private static final long waitStatusOffset;
    private static final long nextOffset;

    static {
        try {
            stateOffset = unSafe.objectFieldOffset(AbstractQueuedSynchronizerTry.class.getDeclaredField("state"));
            headOffset = unSafe.objectFieldOffset(AbstractQueuedSynchronizerTry.class.getDeclaredField("head"));
            tailOffset = unSafe.objectFieldOffset(AbstractQueuedSynchronizerTry.class.getDeclaredField("tail"));

            waitStatusOffset = unSafe.objectFieldOffset(AbstractQueuedSynchronizerTry.class.getDeclaredField("waitStatus"));
            nextOffset = unSafe.objectFieldOffset(AbstractQueuedSynchronizerTry.class.getDeclaredField("next"));

        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int state;
    //为什么要加transient  ,todo 不需要序列化?
    private transient volatile CLHNode head;
    private transient volatile CLHNode tail;

    protected AbstractQueuedSynchronizerTry() {
    }

    public int getState() {
        return state;
    }

    public void setState(int newState) {
        this.state = newState;
    }

    public final int getQueueLength() {
        //尾到头计算长度
        int n = 0;
        for (AbstractQueuedSynchronizerTry.CLHNode p = tail; p != null; p = p.prev) {
            if (p.thread != null) {
                ++n;
            }
        }
        return n;
    }

    public void setHead(CLHNode node) {
        head = node;
        head.thread = null;
        head.prev = null;
        // 为什么不需要设置head.next = null 需要好好理解下这个方法  场景是把等待的queue 设置成head
    }

    /*private AbstractQueuedSynchronizer.Node enq(final AbstractQueuedSynchronizer.Node node) {
        for (;;) {
            AbstractQueuedSynchronizer.Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new AbstractQueuedSynchronizer.Node()))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }*/
    private CLHNode enq(final CLHNode node) {
        for (; ; ) {
            CLHNode t = tail;
            if (t == null) {// initialize for no queue thread exists
                if (CASHead(new CLHNode())) {
                    tail = head;
                }
            } else {
                node.prev = t;
                if (CASTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }

    public final Collection<Thread> getExclusiveQueuedThreads() {
        ArrayList<Thread> list = Lists.newArrayList();
        for (AbstractQueuedSynchronizerTry.CLHNode p = tail; p != null; p = p.prev) {
            if (!p.isShared()) {
                Thread t = p.thread;
                if (t != null) {
                    list.add(t);
                }
            }
        }
        return list;
    }


    public final Collection<Thread> getSharedQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<Thread>();
        for (AbstractQueuedSynchronizerTry.CLHNode p = tail; p != null; p = p.prev) {
            if (!p.isShared()) {
                Thread t = p.thread;
                if (t != null)
                    list.add(t);
            }
        }
        return list;
    }


    private final boolean CASHead(CLHNode update) {
        return unSafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private final boolean CASTail(CLHNode expect, CLHNode update) {
        return unSafe.compareAndSwapObject(this, tailOffset, expect, update);
    }


    private final boolean CASState(int expect, int update) {
        return unSafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    private final boolean CASNext(CLHNode node, CLHNode expect, CLHNode update) {
        return unSafe.compareAndSwapObject(node, nextOffset, expect, update);
    }

    private final boolean CASWaitStatus(CLHNode node, int expect, int update) {
        return unSafe.compareAndSwapInt(node, waitStatusOffset, expect, update);

    }

    /**
     * return true if node is on synchronize Queue CLHNode
     *
     * @param node
     * @return
     */
    protected boolean hasNodeFromTail(CLHNode node) {
        CLHNode t = tail;
        while (true) {
            if (t == node) {
                return true;
            }
            if (t == null) {
                return false;
            }
            t = t.prev;
        }

    }

    public final boolean hasContend() {
        return head != null;
    }

    protected boolean isHeldExclusively() {
        throw new UnsupportedOperationException("subclass of AQS will implement this method ");
    }

    public final Thread getFirstQueuedThred() {
        // handle only fast path , else relay
        return head == tail ? null : fullGetFirstQueuedThread();
    }

    private Thread fullGetFirstQueuedThread() {
        CLHNode h, s;
        Thread st;
        if (((h = head) != null) &&
                ((s = h.next) != null) &&
                (s.prev == head) &&
                ((st = s.thread) != null) ||// 为什么要来2次呢? twice
                (
                        (h = head) != null &&
                                (s = h.next) != null &&
                                s.prev == head && (st = s.thread) != null)
                ) {
            return st;
        }


        CLHNode initNode = tail;
        Thread firstThread = null;
        while (firstThread != null && initNode != head) {
            Thread temp = initNode.thread;
            if (temp != null) {
                firstThread = temp;
            }
            initNode = initNode.prev;
        }
        return firstThread;


    }

    //AQS CLHNode 队列
    final static class CLHNode {

        final static CLHNode SHARED = new CLHNode();
        final static CLHNode EXCLUSIVE = null;


        CLHNode prev;
        CLHNode next;
        CLHNode nextWaiter;
        volatile Thread thread;
        volatile int waitStatus;

        public CLHNode() {
        }

        public CLHNode(Thread thread, CLHNode mode) {
            this.thread = thread;
            this.nextWaiter = mode;
        }

        public CLHNode(Thread thread, int waitStatus) {
            this.thread = thread;
            this.waitStatus = waitStatus;
        }

        final boolean isShared() {
            return this.nextWaiter == SHARED;
        }

        final CLHNode predecessor() {
            Preconditions.checkNotNull(prev);
            return prev;
        }

        private final static class StatusEnum {
            private final static int CANCELLED = 1;
            private final static int SIGNAL = -1;
            private final static int CONDITION = -2;
            private final static int PROPAGATE = -3;
        }


    }

    public class ConditionObject implements Condition {

        @Override
        public void await() throws InterruptedException {

        }

        @Override
        public void awaitUninterruptibly() {

        }

        @Override
        public long awaitNanos(long nanosTimeout) throws InterruptedException {
            return 0;
        }

        @Override
        public boolean await(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public boolean awaitUntil(Date deadline) throws InterruptedException {
            return false;
        }

        @Override
        public void signal() {

        }

        @Override
        public void signalAll() {

        }
    }

}
