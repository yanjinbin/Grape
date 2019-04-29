package com.yanjinbin.concurrent.GuavaConcurrency;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;

// http://ifeve.com/google-guava-cachesexplained/
public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {
        RemovalListener<String, Integer> removalListener = notification -> System.out.println("输出notification key:\t" + notification.getKey() + "\tnotification value:\t" + notification.getValue());

        LoadingCache<String, Integer> loadingCache = CacheBuilder.newBuilder()
                .maximumWeight(100L)
                .weigher((Weigher<String, Integer>) (key, value) -> {
                    System.out.println("输出Key:\t" + key + "\tvalue:\t" + value);
                    return (key.length() + value) * 5;
                })
                .removalListener(removalListener)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) {
                        System.out.println("输出9");
                        return 9;
                    }
                });

        loadingCache.put("aa", 10);
        loadingCache.put("bb", 102);

        System.out.println(loadingCache.get("aa"));
        loadingCache.invalidate("aa");
        System.out.println(loadingCache.get("bbc", () -> {
            System.out.println("输出1000");
            return 1000;
        }));

        System.out.println(loadingCache.stats().evictionCount());
        System.out.println(loadingCache.stats().hitRate());
        System.out.println(loadingCache.get("bb"));


    }
}
