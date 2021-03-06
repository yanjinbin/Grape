/*
package Reflection;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

*/
/**
 * Java反射机制 method 实践
 * Created by Silver & Bullet
 * since 2016-十二月
 *//*

@Slf4j
public class MethodTry {

    public static void main(String[] args) {
        int count = 0;
        System.out.println("---进入method方法实践--");
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method item :
                methods) {
            System.out.println("方法名-----" + item.getName());
            System.out.println("modifier is ------" + item.getModifiers());
            System.out.println("return type is ------- " + item.getReturnType());
            System.out.println("注解是------" + item.getDeclaredAnnotations());
        }

        //通过getMethod 获取制定方法

        Method getNameMethod = personClass.getMethod("getName", null);//第二个参数为参数类型,需要一一对应
        System.out.println("getMethod方法获取getName方法成功-----success!!!!----" + getNameMethod);
        Method setNameMethod = personClass.getMethod("setName", String.class);

        Class<?>[] setNameMethodParameterTypes = setNameMethod.getParameterTypes();

        for (Class item : setNameMethodParameterTypes
                ) {
            System.out.println((count++) + "方法参数类型是" + item.getClass().getName());
        }

        Class<?> returnType = setNameMethod.getReturnType();
        System.out.println("returnType类型是----" + returnType.getClass().getName());
        Person person = new Person();
        //通过Method对象调用方法自身
        Object what = setNameMethod.invoke(person, "高级魔法师");
        System.out.println("what is ------" + what.toString());
        Person person = new Person();
        System.out.println("=---------------打印get和set方法-------------");
        printGetterSetter(person);
    }

    public static void printGetterSetter(Person person) {
        Class<? extends Person> aClass = person.getClass();
        Method[] methods = aClass.getMethods();
        for (Method item : methods) {
            if (isGetterMethod(item)) {
                System.out.println("getter------" + item);
            }
            if (isSetterMethod(item)) {
                System.out.println("setter-----" + item);
            }
        }
    }

    public static boolean isGetterMethod(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetterMethod(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        return method.getParameterTypes().length == 1;
    }
}
*/
