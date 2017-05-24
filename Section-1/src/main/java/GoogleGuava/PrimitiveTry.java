package GoogleGuava;

import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;

import java.util.List;

/**
 * primitive 集合 支持  对应映射 集合类工具方法
 * @author Silver & Bullet
 *         on 十二月-25
 */
public class PrimitiveTry {
    public static void main(String[] args) {
        String join = Ints.join("-", 1, 2, 3, 4, 5);
        System.out.println(join);
        List<Integer> integers = Ints.asList(1, 2, 3, 5, 989, 293);
        for (Integer item :
                integers) {
            System.out.println("item 的值   "+item);
        }

        //int i = Ints.checkedCast(388333221111111L);
        //System.out.println(i);

        int compare = Ints.compare(1, 2);
        System.out.println(compare);

        boolean contains = Ints.contains(new int[]{13, 4, 45, 43}, 43);
        System.out.println(contains);

        //return -1 if not exist
        int i = Ints.indexOf(new int[]{1, 22, 4, 533, 22}, 23);
        System.out.println(i);

        int lastIndexOf = Ints.lastIndexOf(new int[]{2, 333, 22, 3, 45, 9, 29, 9}, 9);
        System.out.println(lastIndexOf);
        int[] ints = {2, 333, 22, 3, 45, 9, 29, 9};

        int max = Ints.max(ints);
        System.out.println(max);

        int saturatedCast = Ints.saturatedCast(222222222222222L);
        boolean b = saturatedCast == Integer.MAX_VALUE;
        System.out.println("is integer max value     "+b);
        //无符号原生类型 in action
        int max1 = UnsignedInts.max(-222, 221, 0, 23, -24);
        System.out.println("max   is     "+max1);
        int i1 = 2 ^ 2;
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("^ operation  is   " +i1);

        //byte array  conversion

        //涉及到字节存储的大小端概念
        //  https://zh.wikipedia.org/wiki/%E5%AD%97%E8%8A%82%E5%BA%8F

        String s = Integer.toHexString(2566);
        System.out.println("hex string is    "+s);

        int byteArray = Ints.fromByteArray(new byte[]{'a', 'b', 'c', 'd'});
        System.out.println("byte conversion result   ?    "+byteArray);
    }
}
