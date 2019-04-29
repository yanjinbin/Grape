package com.yanjinbin.concurrent.FutureTask;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * todo  和guava 的 ListenableFuture 和 Service 一同学习
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class FutureTaskTry {
    public static void main(String[] args) {
        Future<Integer> futureTask = new FutureTask<Integer>(() -> 11);
    }
}
