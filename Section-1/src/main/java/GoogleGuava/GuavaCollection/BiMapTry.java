package GoogleGuava.GuavaCollection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Iterator;
import java.util.Set;

/**
 * handler 键值对的双向映射  特点 能保持 键和值都是唯一的
 * @author Silver & Bullet
 *         on 十二月-11
 */
public class BiMapTry {
    public static void main(String[] args) {
        BiMap<Object, Object> objectHashBiMap = HashBiMap.create();
        objectHashBiMap.put(1,"a");
        objectHashBiMap.put(2,"b");
        objectHashBiMap.put(3,"c");
        //测试BiMap键值是否唯一
        objectHashBiMap.put(4,"y");
      //  objectHashBiMap.put("y","y");//try not promise success,alternatively, you can use forcePut method
        objectHashBiMap.putIfAbsent(2,"c");

        Set<Object> objectsSet = objectHashBiMap.keySet();
        String d = (String) objectHashBiMap.forcePut(2, "d");
        System.out.println("d的值   "+d);//返回的值是previous
        Iterator<Object> keyIterator = objectsSet.iterator();
        System.out.println("-----------A--我是长长的分割线-----------");
        while (keyIterator.hasNext()){
            System.out.println("key值    "+keyIterator.next());
        }

        Set<Object> valuesSet = objectHashBiMap.values();
        Iterator<Object> valueIterator = valuesSet.iterator();
        System.out.println("-----------B--我是长长的分割线-----------");
        while (valueIterator.hasNext()){
            System.out.println("value值    "+valueIterator.next());
        }
        System.out.println("-----------show BiMap.inverse() method ------");

        BiMap<Object, Object> inverseBiMap = objectHashBiMap.inverse();
        Iterator<Object> inverseKeyIterator = inverseBiMap.keySet().iterator();
        while (inverseKeyIterator.hasNext()){
            System.out.println(inverseKeyIterator.next());
        }
        System.out.println("--------------我是长长的分割线-----------");
        Set<Object> inverseValues = inverseBiMap.values();
        Iterator<Object> inverseValueIterator = inverseValues.iterator();
        while (inverseValueIterator.hasNext()){
            System.out.println(inverseValueIterator.next());
        }


    }
}
