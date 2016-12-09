package GoogleGuava;


import com.google.api.client.repackaged.com.google.common.base.Optional;

import java.util.Iterator;
import java.util.Set;

/**
 * null的处理
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class AvoidNullTry {
    public static void main(String[] args) {
        System.out.println("---guava实战--");
        Optional<String> stringOptional = Optional.fromNullable(s); // s m
        System.out.println("is Present " + stringOptional.isPresent());
        //     Optional<String> mOption = Optional.of(m);//快速抛出null pointer exception异常
        Optional<String[]> stringOption = Optional.of(stringArray);
        String[] strings = stringOption.get();
        Set<String[]> set = stringOption.asSet();
        Iterator<String[]> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.toString());
        }


    }

    public static String s = "s";

    public static String emptyString = "";

    public static String m = null;

    public static String[] stringArray = {"a", null, "n", "b"};

    public static int[] intArray = {1, 2, 3, 4, 5};

}
