package com.yanjinbin.concurrent.Fork_Join;

import java.util.concurrent.ForkJoinTask;

/**
 * @Author Silver bullet
 * @Since 2017/5/17.
 */
public class Fib extends ForkJoinTask {

    final static int threshold = 13;
    volatile int number;

    public Fib(int number) {
        this.number = number;
    }

    public int getAnswer() {
        if (!isDone()) {
            throw new IllegalStateException();
        }
        return number;
    }

    public void run() {
        int n = number;
        if (n < threshold) {
            number = seqFib(n);
        } else {

        }
    }


    private int seqFib(int n) {
        if (n <= 1) return n;
        else return seqFib(n - 1) + seqFib(n - 2);
    }


    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
