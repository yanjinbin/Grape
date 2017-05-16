package com.yanjinbin.concurrent.EventBus;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;

/**
 * 监听 TestEvent 的监听器
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class EventListener {
    @Getter
    public int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }

}