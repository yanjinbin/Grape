package com.yanjinbin.concurrent.chapter_1;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @Author Silver bullet
 * @Since 2017/6/29.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    private int getNext() {
        return value++; //
    }
}
