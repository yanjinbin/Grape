package com.yanjinbin.concurrent.Guava_EventBus.testSubEvent;

import com.google.common.eventbus.Subscribe;

/**
 * @Author Silver bullet
 * @Since 2017/5/16.
 */

public class NumberListener {

    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("Message:" + lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}