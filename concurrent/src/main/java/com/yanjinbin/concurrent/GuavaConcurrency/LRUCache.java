package com.yanjinbin.concurrent.GuavaConcurrency;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/tingting256/article/details/52919453
 * 简单用LinkedHashMap来实现的LRU算法的缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}