package GoogleGuava.GuavaCollection;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * @author Silver Bullet
 * @since 十二月-11
 */
public class ClassToInstanceMapTry {
    public static void main(String[] args) {
        System.out.println("--------解决key不同类型的class to instance map问题--------");

        ClassToInstanceMap<Number> numberMutableClassToInstanceMap = MutableClassToInstanceMap.create();

        numberMutableClassToInstanceMap.put(Integer.class,Integer. valueOf(3));
        Number number = numberMutableClassToInstanceMap.get(Integer.class);
        System.out.println(number.intValue());
        System.out.println(number.doubleValue());


    }
}
