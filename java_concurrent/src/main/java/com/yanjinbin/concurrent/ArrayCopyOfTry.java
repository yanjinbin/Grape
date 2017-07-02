package com.yanjinbin.concurrent;

import java.util.Arrays;

/**
 * array.copyof
 *
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class ArrayCopyOfTry {
    public static void main(String[] args) {
        int[] ints = Arrays.copyOf(new int[]{1, 2, 3, 4, 5}, 3);//底层还是调用的 System.arrayCopy()

    }
}
