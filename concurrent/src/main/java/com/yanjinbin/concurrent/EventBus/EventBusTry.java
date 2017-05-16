package com.yanjinbin.concurrent.EventBus;

import com.google.common.eventbus.EventBus;

/**
 * http://www.cnblogs.com/peida/p/EventBus.html
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class EventBusTry {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:" + listener.getLastMessage());

    }

}


