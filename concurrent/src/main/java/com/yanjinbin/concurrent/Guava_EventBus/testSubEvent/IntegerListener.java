package com.yanjinbin.concurrent.Guava_EventBus.testSubEvent;

import com.google.common.eventbus.Subscribe;

/**
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class IntegerListener {


    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
        System.out.println("Message:" + lastMessage);
    }

    public Integer getLastMessage() {
        return lastMessage;
    }

}
