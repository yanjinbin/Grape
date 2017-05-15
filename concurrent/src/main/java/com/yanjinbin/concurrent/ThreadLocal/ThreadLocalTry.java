package com.yanjinbin.concurrent.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * todo ThreadLocal 用法
 * https://goo.gl/3QZvv8 ThreadLocal 用法 示例
 *
 * @Author Silver bullet
 * @Since 2017/5/9.
 */

//ThreadLocal 使用场景
//  ThreadLocal通常用来共享数据，当你想在多个方法中使用某个变量，这个变量是当前线程的状态，其它线程不依赖这个变量，你第一时间想到的就是把变量定义在方法内部，然后再方法之间传递参数来使用，这个方法能解决问题，但是有个烦人的地方就是，每个方法都需要声明形参，多处声明，多处调用。影响代码的美观和维护。有没有一种方法能将变量像private static形式来访问呢？这样在类的任何一处地方就都能使用。这个时候ThreadLocal大显身手了。


public class ThreadLocalTry {
    //
    static ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>() {

        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName() + "initialValue");
            return new HashMap();
        }
    };
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

        //    private final static Map map = new HashMap();

        int id;


        public T1(int id) {

            this.id = id;

        }

        public void run() {

            Map map = threadLocal.get(); //

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



