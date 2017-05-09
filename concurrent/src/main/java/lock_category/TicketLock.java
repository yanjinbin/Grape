package lock_category;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
public class TicketLock {

    private AtomicInteger serviceNum = new AtomicInteger();

    private AtomicInteger ticketNum = new AtomicInteger();

    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>();

    private void lock() {
        // plus one atomic way
        int my_ticket = ticketNum.getAndDecrement();
        LOCAL.set(my_ticket);
        while (my_ticket != serviceNum.get()) {
            // no-limit cycle
        }
    }
}
