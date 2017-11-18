package com.yanjinbin.concurrent.Guava_EventBus;

import lombok.Data;

/**
 * 事件类
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
@Data
public class TestEvent {

    private final int message;

    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:" + message);
    }

}