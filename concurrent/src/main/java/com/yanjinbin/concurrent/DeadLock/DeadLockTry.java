package com.yanjinbin.concurrent.DeadLock;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * todo 死锁情况分析
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class DeadLockTry {
    public static void main(String[] args) {
        int a = 1;
        test();
        System.out.println("哈哈哈");
        a = 12 + 10;
    }

    public static void test() {


        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("语文", "1");
        map.put("数学", "2");
        map.put("英语", "3");
        map.put("历史", "4");
        map.put("政治", "5");
        map.put("地理", "6");
        map.put("生物", "7");
        map.put("化学", "8");
        map.put("物理", "9");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
