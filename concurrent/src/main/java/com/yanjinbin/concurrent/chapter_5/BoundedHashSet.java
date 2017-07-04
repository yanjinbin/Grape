package com.yanjinbin.concurrent.chapter_5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 *
 * 构造有界阻塞的容器
 *
 * @Author Grape
 * @Since 2017/7/4.
 */
public class BoundedHashSet<V> {
    private final Set<V> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<V>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(V v) throws InterruptedException {
        boolean added = false;
        try {
            semaphore.acquire();
            added = set.add(v);
            return added;
        } catch (InterruptedException ex) {
            throw new InterruptedException();
        } finally {
            if (!added) {
                semaphore.release();
            }
        }
    }
}
