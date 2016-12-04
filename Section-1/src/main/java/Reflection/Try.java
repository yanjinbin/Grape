package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Silver & Bullet
 * since 2016-十一月
 */
public class Try {
    public static void main(String[] args) {
        try {
            Class<?> personClass = Class.forName("Reflection.Person");
            ClassLoader classLoader = personClass.getClassLoader();
            System.out.println("ClassLoader名字"+classLoader.getClass().getName());
            Method[] methods = personClass.getDeclaredMethods();
            for (Method item :
                    methods) {
                System.out.println("方法名"+item.getName());
                System.out.println("修饰关键词"+item.getModifiers());
                System.out.println("返回类型"+item.getReturnType().getName());
                System.out.println("generic return type"+item.getGenericReturnType().toString());
            }
            Field[] fields = personClass.getFields();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
