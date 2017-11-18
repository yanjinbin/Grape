package com.yanjinbin.concurrent.thread4;

/**
 * http://www.cnblogs.com/skywang12345/p/3479224.html
 * <p>
 * http://www.cnblogs.com/skywang12345/p/3479024.html
 * <p>
 * Created by yanjinbin on 2017/4/30.
 */
public class WaitTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        synchronized (t1) {//获取这个对象 t1 的同步锁

            try {
                System.out.println(Thread.currentThread().getName() + "\tstart t1 !!!");
                t1.start();//main 进入wait()阻塞状态

                System.out.println(Thread.currentThread().getName() + "\twait()!!!");
                t1.wait();//理解t1.wait() 需要理解t1线程出入runnable（）状态，然后要想调用wait() 需要run() run所以 调用public void run（ ）方法 就会出来t1 is called notify()


                System.out.println(Thread.currentThread().getName() + "\tcontinue !!!");

            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
