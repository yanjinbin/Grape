package Collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Silver Bullet
 * @since 一月-05
 */
public class CollectionTry {
    public static void  main(String[] args) {
        // java  原生的集合框架  暂时放弃 , 已经比较熟悉了 不用再看了
        String[] list = {"1", "2", "3"};
        List<String> stringList = Arrays.asList(list);
        ArrayList<String> strings = Lists.newArrayList(stringList);
        strings.add("4");
        System.out.println(strings);
        // stringList.add("4");



        //为什么捏  askme
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a);

    }
}
