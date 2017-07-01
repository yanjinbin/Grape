package com.yanjinbin.concurrent.chapter_3;

/**
 * 避免对象逸出  1  私有化构造函数 2  通过静态工厂方法创建一个实例
 *
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class SafeConstruct {

    private final EventListener eventListener;

    private SafeConstruct() {
        eventListener = new EventListener() {
            @Override
            public void listen(Event e) {
                this.listen(e);
            }
        };
    }


    public SafeConstruct newInstance(EventSource eventSource) {
        SafeConstruct safeConstruct = new SafeConstruct();
        eventSource.registerListener(safeConstruct);
        return safeConstruct;

    }

    public void doSomething(Event e) {
        System.out.println("do something\t");
    }

}

class EventSource {
    public void registerListener(SafeConstruct safeConstruct) {
        System.out.println("registering\t");
    }
}

class EventListener implements Listener {

    private SafeConstruct safeConstruct;

    @Override
    public void listen(Event e) {

    }
}

interface Listener {
    public void listen(Event e);
}

class Event {

}