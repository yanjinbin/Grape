package GoogleGuava.GuavaCollection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.*;

import java.util.List;
import java.util.Set;

/**
 * 新的集合类型,概念上来说是从数学语义上的几何角度出发
 * 允许元素重复,顺序insensitive
 *
 * 所有multiset实现了随不重复元素的现象增长
 * Created by yanjinbin on 16-12-11.
 */
public class MultiSetTry {
    public static void main(String[] args) {
        Multiset<Object> hashMultiset = HashMultiset.create();
        hashMultiset.add('a');
        hashMultiset.add("b");
        hashMultiset.add("a");
        hashMultiset.add('a');
        hashMultiset.add('a',3);
        hashMultiset.setCount('a',4);//3+2→4
        int a = hashMultiset.count('a');

        //键为element  值为count
        Set<Multiset.Entry<Object>> entries = hashMultiset.entrySet();
        for (Multiset.Entry item:
        entries){
            System.out.println(item.getCount());
            System.out.println(item.toString());
            System.out.println(item.getElement());
            System.out.println("--------我是分隔符---------");
        }
        Set<Object> elementSet = hashMultiset.elementSet();
        int size = elementSet.size();

        System.out.println("a的值  "+a);
        //multiset的子类 SortedMultiSet
        TreeMultiset<Comparable> treeMultiset = TreeMultiset.create();
        treeMultiset.add("a");
        treeMultiset.add("b");
        treeMultiset.add("c");
        treeMultiset.add("d");
        treeMultiset.setCount("b",5);
        //open意思的意思是下限a不考虑,closed反之
        SortedMultiset<Comparable> comparableSortedMultiset = treeMultiset.subMultiset("c", BoundType.OPEN, "d", BoundType.CLOSED);
        System.out.println("ratio is  "+comparableSortedMultiset.size()+"/"+treeMultiset.size() );


        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> set2 = Sets.newHashSet(4, 5, 6);
        Set<List<Integer>> lists = Sets.cartesianProduct(set1, set2);
        System.out.println("====set 笛卡尔====");
        System.out.println(JSON.toJSONString(lists));
        for (List<Integer> item : lists) {
            System.out.println(item.get(0));
        }


    }





}
