package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class SetListIllusion {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            //list.remove((Integer)i); //两者是有区别的 一个去除 i 对象  一个是去除 i 索引说在位置
            list.remove(i);
        }
        // list.remove  每一次 remove 都会重新构造一个对象

        System.out.println("\tset:" + set + "\tlist:" + list);

    }
}
