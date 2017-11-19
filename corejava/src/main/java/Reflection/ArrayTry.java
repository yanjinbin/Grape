package Reflection;

import java.lang.reflect.Array;

/**
 * Java 数组 反射
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class ArrayTry {
    public static void main(String[] args) {
        System.out.println("---------------进入Java 数组 反射 实践--------------");


        int[] intArray = (int[]) Array.newInstance(int.class, 3);//创建什么类型的数组,数组大小;
        Array.set(intArray,0,1);
        Array.set(intArray,1,2);
        Array.set(intArray,2,3);
       // Array.set(intArray,3,4); //多添加个元素 会抛 ArrayIndexOutOfBoundsException
        for (int item :
                intArray) {
            System.out.println("值"+item);
        }

        //比较讨巧的方式获取数组对象
        String theClassName ="[Ljava.lang.String;";
        Class aClass = getClass(theClassName);
        Class<?> arrayClass = Array.newInstance(aClass, 0).getClass();
        System.out.println("is array " +arrayClass.isArray());


        //获取数组的成员类型
        String[] strings = new String[3];
        Class<? extends String[]> stringsClass = strings.getClass();
        /**
         * Returns the {@code Class} representing the component type of an
         * array.  If this class does not represent an array class this method
         * returns null.
         *
         */
        Class<?> componentType = stringsClass.getComponentType();
        System.out.println("component type is "+componentType);


    }


    //根据数据类型 生成对应的Class
    public static Class getClass(String className){
        // 8  primitive data type handle
        if("int".equals(className) ) {
            return int.class;
        }
        if("long".equals(className)) {
            return long.class;
        }

        //reference type handle
        try {
            return  Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }
}
