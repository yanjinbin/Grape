package GoogleGuava;


import com.google.api.client.repackaged.com.google.common.base.Optional;

/**
 * null的处理
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class AvoidNullTry {
    public static void main(String[] args) {
        System.out.println("---guava实战--");
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
        Optional<Object> absent1 = possible.absent();
        
        Integer integer = possible.get();
        Optional<Object> absent = absent1;
        Optional<String[]> fromNullable = Optional.fromNullable(array);//turn the given possible-null reference into an Optional
        //   System.out.println(fromNullable.isPresent());
//        String[] or = fromNullable.or(array);
//        for (String item :
//                or) {
//            System.out.println(item);
//        }
//        String[] strings = fromNullable.get();
//        System.out.println(fromNullable.isPresent());
//        Optional<Object> optional = Optional.of(null);//如果是null  throw NullPointerException
//        optional.isPresent();
//        optional.get();

        Optional optional = getOptional(array);
        System.out.println("不包含Null引用?------" + optional.isPresent());
    }

    public static String[] array = {"a", null, "n", "b"};

    public static Optional getOptional(String[] array) {
        //  return Optional.fromNullable(array);
        return Optional.of(array);
    }
}
