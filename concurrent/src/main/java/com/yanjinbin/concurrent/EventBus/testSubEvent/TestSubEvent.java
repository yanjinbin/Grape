package com.yanjinbin.concurrent.EventBus.testSubEvent;

import com.google.common.eventbus.EventBus;

/**
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class TestSubEvent {


    public static void main(String[] args) throws Exception {

        EventBus eventBus = new EventBus("test");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        eventBus.post(new Integer(100));

        System.out.println("integerListener message:" + integerListener.getLastMessage());
        System.out.println("numberListener message:" + numberListener.getLastMessage());

        // 200 只能被 NumberListener 监听到
        eventBus.post(new Long(200L));

        System.out.println("integerListener message:" + integerListener.getLastMessage());
        System.out.println("numberListener message:" + numberListener.getLastMessage());

    }

}
