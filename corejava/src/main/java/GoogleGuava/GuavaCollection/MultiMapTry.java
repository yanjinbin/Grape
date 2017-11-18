package GoogleGuava.GuavaCollection;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.*;

/**
 * MultiMap处理key到多个values也就是collection的映射关系
 *
 * @author Silver & Bullet
 *         on 十二月-11
 */
public class MultiMapTry {
    public static void main(String[] args) {
        ImmutableMultimap<Integer, String> immutableMultimap = ImmutableMultimap.of(1, "a").of(2, "b").of(3, "c");
        //?
        boolean isExist = immutableMultimap.containsValue("b");
        boolean containsKey = immutableMultimap.containsKey(1);
        System.out.println("is exist ?   " + isExist);
        System.out.println("contains key  ?" + containsKey);


        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put(1, "e");
        hashMultimap.put(2, "q");
        hashMultimap.put(3, "z");
        hashMultimap.put(3, "y");
        boolean isContainsEntry = hashMultimap.containsEntry(2, "z");

        System.out.println("contains key-value pair ?   " + isContainsEntry);
        Multiset<Object> keys = hashMultimap.keys();

        System.out.println("size is ?   " + keys.size());

        Set<Map.Entry<Object, Object>> entries = hashMultimap.entries();

        System.out.println("entry size is ?  " + entries.size());


        Map<Object, Collection<Object>> collectionMap = hashMultimap.asMap();
        boolean containsValue = hashMultimap.containsValue("e");
        System.out.println("contain value ?  " + containsValue);
        Multimap multimap = hashMultimap;
        boolean b = hashMultimap.putAll(hashMultimap);
        System.out.println("two objects is equal ?  " + Objects.equal(multimap, hashMultimap));


        System.out.println("--------E-分割线在此-------");

        Iterator<Map.Entry<Object, Object>> entryIterator = hashMultimap.entries().iterator();
        while (entryIterator.hasNext()) {
            System.out.println(entryIterator.next().toString());
        }

        System.out.println("---------分割线在此-------");

        Iterator<Object> keyIterator = hashMultimap.keys().iterator();
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        System.out.println("--------A-分割线在此-------");

        Iterator<Object> valueIterator = hashMultimap.values().iterator();
        while (valueIterator.hasNext()) {
            System.out.println(valueIterator.next());
        }
        System.out.println("--------B-分割线在此-------");

        Set<Object> keySet = hashMultimap.keySet();
        Iterator<Object> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()){
            System.out.println(keySetIterator.next());
        }
        //while (keySet.iterator().hasNext()) {//错误写法
        //    System.out.println(keySet.iterator().next());
        //}

        System.out.println("-------C--分割线在此-------");

        TreeSet<String> strings = new TreeSet<String>();
        strings.add("w");
        strings.add("p");
        Collection collection2 = multimap.get(2);
        Iterator iterator = collection2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println("------D---分割线在此-------");

        Collection collection1 = multimap.replaceValues(2, strings);
        System.out.println(collection1.size());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("two collection is equal ?  " + Objects.equal(collection1, collection2));
        boolean contains = multimap.removeAll(3).contains(3);
        System.out.println("is still contain 3 ?   " + contains);


        multimap.clear();
        System.out.println("is Empty ?   " + multimap.isEmpty());
        //  ImmutableMultimap.copyOf()


    }
}
