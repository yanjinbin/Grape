package GoogleGuava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import javax.annotation.Nullable;
import java.util.Comparator;

/**
 * use ordering to build complex comparators
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class OrderingTry {
    public static Integer m = new Integer(3);
    public static Integer n = new Integer(4);

    public static void main(String[] args) {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        Ordering<Object> objectOrdering = Ordering.usingToString();
        //对可排序类型做自然排序,如数字大小,日期先后
        Ordering<Comparable> natural = Ordering.natural();
        //lexicographical ordering  字典排序
        Ordering<Object> objectOrdering1 = Ordering.usingToString();
        //把给定的Comparator转换为比较器
        Ordering.from(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return -1;
            }
        });
        //获取语义上相反的类排序器
        Ordering<Object> reverseOrdering = objectOrdering.reverse();

        //遇到null值的排序的处理
        Ordering<Object> nullsFirstOrder = objectOrdering.nullsFirst();
        Ordering<Object> nullsLastOrder = objectOrdering.nullsLast();

        //合成另一个比较器,处理两者相等的情况
        Ordering<Object> compoundOrdering = objectOrdering.compound(nullsFirstOrder);

        //基于处理类型T的排序器,返回给类型的可迭代对象Iterable<T>
        Ordering<Iterable<Object>> lexicographicalOrder = objectOrdering.lexicographical();

        //基于返回值,按照当前排序器排序
        objectOrdering.onResultOf(new Function<Object, Integer>() {
            @Override
            @Nullable
            public Integer apply(@Nullable Object input) {

                return 1;
            }
        });
        //   Ordering<Person> personOrdering = new Ordering<Person>();
    }
}
