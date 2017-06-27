package chapter7;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 43条
 * todo 为什么零长度数组是不可变的？？
 * <p>
 * 返回空对象 而不是 null
 *
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class EmptyReturnTypeTry {
    public static void main(String[] args) {

    }

    private Integer[] getIntegers() {

        return list.toArray(EMPTY_ARRAY);
    }

    private List<Integer> getList(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return ((List<Integer>) collection);
    }

    private static final Integer[] EMPTY_ARRAY = new Integer[0];

    private final List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
}
