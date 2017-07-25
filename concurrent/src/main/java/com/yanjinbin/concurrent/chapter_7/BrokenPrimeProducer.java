package com.yanjinbin.concurrent.chapter_7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @Author Grape
 * @Since 2017/7/18.
 */
public class BrokenPrimeProducer extends Thread {
    private volatile boolean cancelled = false;

    private final BlockingQueue<BigInteger> queue;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void cancell() {
        cancelled = true;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }

        } catch (InterruptedException ex) {


        }
    }

    public void consumePrimes() {
        BlockingQueue<BigInteger> primes;
        primes = new ArrayBlockingQueue<BigInteger>(16);

        BrokenPrimeProducer primeProducer = new BrokenPrimeProducer(primes);
        primeProducer.start();
        try {
            while (needMorePrimnes()) {
                consume(primes.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume(BigInteger take) {
    }

    private boolean needMorePrimnes() {
        return false;
    }
}
