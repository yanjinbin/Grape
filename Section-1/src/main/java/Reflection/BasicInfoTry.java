package Reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过反射获取类的基本信息,也就是java 语法糖 grammar sugar
 * Created by Silver & Bullet
 * since 2016-十一月
 */
@Slf4j
public class BasicInfoTry {
    public static void main(String[] args) {
        try {


            Class<?> personClass = Class.forName("Reflection.Person");
            Class<Person> another = Person.class;
            System.out.println("is Class equal ?========"+another.equals(personClass));
            System.out.println("super class is ====="+another.getSuperclass().getName());
            System.out.println("implemented interfaces are ===="+another.getInterfaces());
            System.out.println("package info ===="+another.getPackage());
            Constructor<?>[] constructors = another.getConstructors();
            System.out.println("constructor info is shown bellow ");
            for (Constructor item:constructors){
                System.out.println("parameter type is ===== "+item.getParameterTypes());
            }



            System.out.println("simple name ====="+personClass.getSimpleName());
            ClassLoader classLoader = personClass.getClassLoader();



            System.out.println("ClassLoader名字===="+classLoader.getClass().getName());
            Method[] methods = personClass.getDeclaredMethods();
            Method[] allMethods = personClass.getMethods();
            for (Method item :
                    methods) {
                System.out.println("方法名======"+item.getName());
                int modifiers = item.getModifiers();
                System.out.println("修饰关键词-======="+ modifiers);//1 public 2 private 4 protected
                System.out.println(Modifier.isPublic(modifiers));
                System.out.println("返回类型======="+item.getReturnType().getName());
                System.out.println("generic return type======="+item.getGenericReturnType().toString());
            }


            System.out.println("print all methods include inherited method from super class ");

            for (Method item :
                    allMethods) {
                System.out.println("method name is====="+item.getName());
                System.out.println("class is===== "+item.getClass());
                System.out.println("Return type is===="+item.getReturnType());
                System.out.println("Default value is====== "+item.getDefaultValue());
                System.out.println("Parameter type is ====="+item.getParameterTypes());
                System.out.println("Parametet is ======"+item.getParameters());
            }
            Field[] fields = personClass.getFields();
            for (Field item:fields
                 ) {
                System.out.println("Field name is======"+item.getName());//return  public modified filed name
                System.out.println("Declare class is======="+item.getDeclaringClass());//返回the owner of public filed name
                System.out.println("modifiers is======"+item.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            log.error("报 classnotfound exception");
       //     e.printStackTrace();
        }
    }
}
