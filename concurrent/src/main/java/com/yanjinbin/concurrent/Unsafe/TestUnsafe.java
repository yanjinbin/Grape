package com.yanjinbin.concurrent.Unsafe;

/**
 * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/sun/misc/Unsafe.java

 * @Author Silver bullet
 * @Since 2017/5/10.
 */


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author Silver_bullet
 */
public class TestUnsafe {

    public static void main(String[] args) {
        Node node = new Node();
        /**
         * 通过CAS方法更新node的next属性
         * 原子操作
         */
        System.out.println(node.next);
        boolean flag = node.casNext(null, new Node());
        System.out.println(flag);
        System.out.println(node);
        System.out.println(node.next);
    }

    private static class Node {

        private static final sun.misc.Unsafe UNSAFE;
        private static final long nextOffset;

        static {
            try {
                //keystep
                UNSAFE = getUnsafe();
                Class<?> k = Node.class;
                // nextoffset 代表 Node 成员变量 Node next
                nextOffset = UNSAFE.objectFieldOffset
                        (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        volatile Node next;

        /**
         * 获取Unsafe的方法
         * 获取了以后就可以愉快的使用CAS啦
         *
         * @return
         */
        public static Unsafe getUnsafe() {
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                return (Unsafe) f.get(null);
            } catch (Exception e) {
                return null;
            }
        }

        /**
         * 使用Unsafe CAS方法
         *
         * @param cmp 目标值与cmp比较，如果相等就更新返回true；如果不相等就不更新返回false；
         * @param val 需要更新的值；
         * @return
         */
        boolean casNext(Node cmp, Node val) {
            /**
             * compareAndSwapObject(Object var1, long var2, Object var3, Object var4)
             * var1 操作的对象
             * var2 操作的对象属性
             * var3 var2与var3比较，相等才更新
             * var4 更新值
             */
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }
    }
}