package com.yanjinbin.concurrent.lock_category;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class TicketLock {

    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>();
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();

    private void lock() {
        // plus one atomic way
        int my_ticket = ticketNum.getAndDecrement();
        LOCAL.set(my_ticket);
        while (my_ticket != serviceNum.get()) {
            // no-limit cycle
        }
    }
}
