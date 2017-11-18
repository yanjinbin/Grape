package concurrent_in_pratice.chapter_3;

interface Listener {
    public void listen(Event e);
}

/**
 * 避免对象逸出  1  私有化构造函数 2  通过静态工厂方法创建一个实例
 *
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class SafeListener {

    private final EventListener eventListener;

    private SafeListener() {
        eventListener = new EventListener() {
            @Override
            public void listen(Event e) {
                this.listen(e);
            }
        };
    }


    public SafeListener newInstance(EventSource eventSource) {
        SafeListener safeListener = new SafeListener();
        eventSource.registerListener(safeListener);
        return safeListener;

    }

    public void doSomething(Event e) {
        System.out.println("do something\t");
    }

}

class EventSource {
    public void registerListener(SafeListener safeListener) {
        System.out.println("registering\t");
    }
}

class EventListener implements Listener {

    private SafeListener safeListener;

    @Override
    public void listen(Event e) {

    }
}

class Event {

}