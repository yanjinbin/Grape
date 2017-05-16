package com.yanjinbin.concurrent.WeakReference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * http://www.cnblogs.com/Skyar/p/5962253.html
 *
 * @Author Silver bullet
 * @Since 2017/5/15.
 */
public class WeakReferenceTry {
    private static String test() {
        String a = new String("a");
        WeakReference<String> b = new WeakReference<String>(a);
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<String, Integer>();
        weakMap.put(b.get(), 1);
        a = null;
        System.gc();
        String c = "";
        try {
            c = b.get().replace("a", "b");
            return c;
        } catch (Exception e) {
            c = "c";
            return c;
        } finally {
            c += "d";
            return c + "e";
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
