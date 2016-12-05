package Reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * Java反射机制 method 实践
 * Created by Silver & Bullet
 * since 2016-十二月
 */
@Slf4j
public class MethodTry {
    public static void main(String[] args) {
        System.out.println("---进入method方法实践--");
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method item :
                methods) {
            System.out.println("方法名-----"+item.getName());
            System.out.println("modifier is ------"+item.getModifiers());
            System.out.println("return type is ------- "+item.getReturnType());
            System.out.println("注解是------"+item.getDeclaredAnnotations());
        }

        //通过getMethod 获取制定方法
        try {
            Method getNameMethod = personClass.getMethod("getName", null);
            System.out.println("getMethod方法获取getName方法成功-----success!!!!----"+getNameMethod);
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(),e);
            e.printStackTrace();
        }
    }
}
