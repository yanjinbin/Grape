package com.yanjinbin.concurrent.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://www.cnblogs.com/everSeeker/p/5105842.html
 *
 * todo ThreadLocal 用法
 * https://goo.gl/3QZvv8 ThreadLocal 用法 示例
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */

//ThreadLocal 使用场景
//ThreadLocal通常用来共享数据，当你想在多个方法中使用某个变量，这个变量是当前线程的状态，其它线程不依赖这个变量，你第一时间想到的就是把变量定义在方法内部，然后再方法之间传递参数来使用，这个方法能解决问题，但是有个烦人的地方就是，每个方法都需要声明形参，多处声明，多处调用。影响代码的美观和维护。有没有一种方法能将变量像private static形式来访问呢？这样在类的任何一处地方就都能使用。这个时候ThreadLocal大显身手了。

// keystep
// 首先，ThreadLocalMap并不是为了解决线程安全问题，而是提供了一种将实例绑定到当前线程的机制，类似于隔离的效果，实际上自己在方法中new出来变量也能达到类似的效果。ThreadLocalMap跟线程安全基本不搭边，绑定上去的实例也不是多线程公用的，而是每个线程new一份，这个实例肯定不是共用的，如果共用了，那就会引发线程安全问题。ThreadLocalMap最大的用处就是用来把实例变量共享成全局变量，在程序的任何方法中都可以访问到该实例变量而已。网上很多人说ThreadLocalMap是解决了线程安全问题，其实是望文生义，两者不是同类问题。

public class ThreadLocalTry {
    //
//    static ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>() {
//
//        @Override
//        protected HashMap initialValue() {
//            System.out.println(Thread.currentThread().getName() + "initialValue");
//            return new HashMap();
//        }
//    };
    //

    public static void main(String[] args) {

        Thread[] runs = new Thread[15];

        T1 t = new T1(1);

        for (int i = 0; i < runs.length; i++) {

            runs[i] = new Thread(t);

        }

        for (int i = 0; i < runs.length; i++) {

            runs[i].start();

        }

    }

    public static class T1 implements Runnable {

        private final static Map map = new HashMap();

        int id;


        public T1(int id) {

            this.id = id;

        }

        @Override
        public void run() {

            // Map map = threadLocal.get(); //

            for (int i = 0; i < 20; i++) {

                map.put(i, i + id * 100);

                try {

                    Thread.sleep(100);

                } catch (Exception ex) {

                }

            }

            System.out.println(Thread.currentThread().getName() + "#map.size()=" + map.size() + "#" + map);

        }

    }

}



