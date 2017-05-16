package com.yanjinbin.concurrent.excutor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class ExcutorPoolExecutorTry {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    // Packing and unpacking ctl
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    // private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING,0));

    public static void main(String[] args) {

        System.out.println("移位数目\t\t" + COUNT_BITS);

        String s = Integer.toBinaryString(-1);
        System.out.println(s.length());
        System.out.println(s);
        System.out.println(RUNNING); // -1 << 29
        System.out.println(Integer.toBinaryString(RUNNING));

        int i = ctlOf(RUNNING, 0);
        System.out.println("i 的值是------\t" + i);


        System.out.println("------shutdown state-----");
        String s1 = Integer.toBinaryString(0);
        System.out.println(s1.length());
        System.out.println(s1);
        System.out.println(SHUTDOWN);
        System.out.println(Integer.toBinaryString(SHUTDOWN));


        System.out.println("------StopState-----");
        String s2 = Integer.toBinaryString(1);
        System.out.println(s2.length());
        System.out.println(s2);
        System.out.println(STOP);
        System.out.println(Integer.toBinaryString(STOP));

        System.out.println("------Tidy State----");
        String s3 = Integer.toBinaryString(2);
        System.out.println(s3.length());
        System.out.println(s3);
        System.out.println(TIDYING);
        System.out.println(Integer.toBinaryString(TIDYING));


        System.out.println("---Terminate state----");
        String s4 = Integer.toBinaryString(3);
        System.out.println(s4.length());
        System.out.println(s4);
        System.out.println(TERMINATED);
        System.out.println(Integer.toBinaryString(TERMINATED));
        System.out.println("---------------");
        int j = -1 << 29;
        System.out.println(Integer.toBinaryString(j).substring(0, 4));
        j = 0 << 29;
        System.out.println(Integer.toBinaryString(j));
        j = 1 << 29;
        System.out.println(Integer.toBinaryString(j).substring(0, 3));
        j = 2 << 29;
        System.out.println(Integer.toBinaryString(j).substring(0, 4));
        j = 3 << 29;
        System.out.println(Integer.toBinaryString(j).substring(0, 4));


    }


}
