package GoogleGuava;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * use ordering to build complex comparators
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class OrderingTry {
    public static void main(String[] args) {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };


        //   Ordering<Person> personOrdering = new Ordering<Person>();
    }

    public static Integer m = new Integer(3);

    public static Integer n = new Integer(4);
}
