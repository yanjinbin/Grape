package GoogleGuava;


import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Set;

/**
 * null的处理 absent 和present 2种语义
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class AvoidNullTry {
    public static void main(String[] args) {
        System.out.println("---guava实战--");
        Optional<String> stringOptional = Optional.fromNullable(s); // s nullString
        System.out.println("is Present " + stringOptional.isPresent());
        //     Optional<String> mOption = Optional.of(nullString);//快速抛出null pointer exception异常
        Optional<String[]> stringOption = Optional.of(stringArray);
        Set<String[]> stringSet = stringOption.asSet();
        Optional<String> mOptional = Optional.fromNullable(nullString);
        boolean equals = Optional.absent().equals(mOptional);
        System.out.println("equals value is     "+equals);
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add(null);
//        Iterable iterable = Optional.presentInstances(arrayList);
//        Iterator iterator = iterable.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        System.out.println("is Present ?  " + mOptional.isPresent());
        String defaultStr = mOptional.or("默认值usa");
        System.out.println(defaultStr);

        String s = MoreObjects.firstNonNull(nullString, AvoidNullTry.s);//取不为null的值,取不到 抛null pointer
        System.out.println("返回 s的值   " + s.equals(s));

        String s1 = Optional.of(emptyString).orNull();
        System.out.println("s1 is null?  " + StringUtils.isEmpty(s1));

        String s2 = Optional.fromNullable(nullString).orNull();
        System.out.println("s2 is null?  " + StringUtils.isEmpty(s2));
        System.out.println("s2 is null or empty " + Strings.isNullOrEmpty(s2));
        System.out.println("s2 is empty -----" + Strings.nullToEmpty(s2) + "----");

    }

    public static ArrayList arrayList = new ArrayList();

    public static String s = "s";

    public static String emptyString = "";

    public static String blankString = "    ";

    public static String nullString ;

    public static String[] stringArray = {"a", "b", "n", "b"};

    public static int[] intArray = {1, 2, 3, 4, 5};


}
