package com.yanjinbin.concurrent.chapter_3;

/**
 * nextodo this 对象引用逸出 chapter3.2
 * 下面这篇文章讲解的很好
 * <p>
 * http://blog.csdn.net/zyh5540/article/details/51173808
 */


public class ThisEscape {

    public static void main(String[] args) {
        EventSource eventSource = new EventSourceImpl();
        ThisEscape thisEscape = new ThisEscape(eventSource);
    }

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                // 通过ThisEscape.this就可以引用外围类对象, 但是此时外围类对象可能还没有构造完成, 即发生了外围类的this引用的逃逸
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }


    static class EventSourceImpl implements EventSource {

        @Override
        public void registerListener(EventListener e) {
            System.out.println("register listener \t");
        }
    }
}