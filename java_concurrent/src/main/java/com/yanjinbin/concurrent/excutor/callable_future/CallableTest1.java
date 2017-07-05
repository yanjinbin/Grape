package com.yanjinbin.concurrent.excutor.callable_future;

import java.util.concurrent.*;

/**
 * 需要确认 是 FutureTask 真正的执行类 自行了 run()方法
 * http://www.cnblogs.com/skywang12345/p/3544116.html
 */
class MyCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        // 执行任务
        for (int i = 0; i < 100; i++)
            sum += i;
        //return sum; 
        return sum;
    }
}

public class CallableTest1 {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建有返回值的任务
        Callable c1 = new MyCallable();
        //执行任务并获取Future对象
        // 实际返回的 FutureTask  这个需要自己去挖掘
        // 输出结果
        Future f1 = pool.submit(c1);
        System.out.println(f1.get());
        //关闭线程池 
        pool.shutdown();
    }
}