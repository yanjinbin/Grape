package com.yanjinbin.concurrent.chapter_1;


import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}