package chapter8;

import java.util.Comparator;

/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class AutoBox {
    public static void main(String[] args) {
//        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
//            public int compare(Integer first, Integer second) {
//                return first < second ? -1 : (first == second ? 0 : 1);
//            }
//        };

        //与 预期相反  基本数据类型 优于包装类 P192
        //    System.out.println(naturalOrder.compare(21, 21));


        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int first = o1;
                int second = o2;
                return first < second ? -1 : (first == second ? 0 : 1);
            }
        };

        System.out.println(naturalOrder.compare(21, 21));
        //混合类型比较的时候，会进行拆箱
        if (i == 42) {// i 拆箱，抛出空指针异常 NullPointerException
            System.out.println("Unbelievable");
        }
        // p194 装箱类型在作为集合的元素 键和值 以及 反射 和泛型的参数话类型的时候
        // 不允许使用基本类型  建议使用 wrapper class
    }

    static Integer i;//初始化是 Null

}
