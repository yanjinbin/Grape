package com.yanjinbin.concurrent.chapter_7;


import com.google.common.collect.Lists;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Grape
 * @Since 2017/7/18.
 */
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = Lists.newArrayList();

    private volatile boolean cancelled = false;

    @Override
    public void run() {
        BigInteger one = BigInteger.ONE;
        while (!cancelled) {
            one = one.nextProbablePrime();
            synchronized (primes) {
                primes.add(one);
            }
        }

    }

    public void cancell() {
        cancelled = true;
    }

    // get 还会涉及到线程安全吗?
//    public List<BigInteger> get() {
//        return primes;
//    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }
}
