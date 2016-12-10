package GoogleGuava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class ObjectsTry {
    public static void main(String[] args) {
        boolean equal = Objects.equal(i, j);
        System.out.println("is equal ?   " + equal);
        boolean newEqual = Objects.equal(m, n);
        System.out.println("is equal ?   " + newEqual);
        //输出哈希值
        System.out.println("输出hashcode     " + Objects.hashCode(i, j, m, n));
        //重写toString方法 beautify code
        MoreObjects.ToStringHelper string = MoreObjects.toStringHelper(AvoidNullTry.class).add("I", 3).add("J", 4);
        System.out.println(string);


        //除order之外的比较器
        ComparisonChain.start().compare(i, j).compare(new Comparable<Object>() {
            public int compareTo(Object o) {
                return m.compareTo(n);
            }
        }, new Comparable<Object>() {
            public int compareTo(Object o) {
                return n.compareTo(m);
            }
        });

    }

    public static int i = 3;
    private static int j = 3;

    public static Integer m = new Integer(3);
    public static Integer n = new Integer(3);
}
