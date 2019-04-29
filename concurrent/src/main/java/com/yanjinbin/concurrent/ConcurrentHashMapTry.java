package com.yanjinbin.concurrent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTry {
    public static void main(String[] args) {
        try {
            final HashMap<String, String> map = new HashMap(2);
            Thread t = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "ftf" + i).start();
                }
            }, "ftf");
            t.start();
            t.join();
        }catch (Throwable ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
