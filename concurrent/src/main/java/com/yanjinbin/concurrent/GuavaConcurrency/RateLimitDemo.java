package com.yanjinbin.concurrent.GuavaConcurrency;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;

// https://manzhizhen.iteye.com/blog/2311691
// https://my.oschina.net/LucasZhu/blog/1808974
// https://zhuanlan.zhihu.com/p/39031921
public class RateLimitDemo {

    public static void main(String[] args) {
        // testNoRateLimiter();
        testWithRateLimiter();
    }

    public static void testNoRateLimiter() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println("call execute.." + i);
        }
        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public static void testWithRateLimiter() {
        Long start = System.currentTimeMillis();
        // 每秒请求数最多2个
        RateLimiter limiter = RateLimiter.create(2);
        // 请求RateLimiter, 超过permits会被阻塞
        for (int i = 0; i < 10; i++) {
            limiter.acquire();
            System.out.println(LocalDateTime.now() + " : call execute.." + i);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

        limiter.acquire();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("继续acquire");
        limiter.acquire();
    }
}
