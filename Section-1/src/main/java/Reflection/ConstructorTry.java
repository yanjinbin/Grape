package Reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 *
 * fetch constructor create new object
 * Created by Silver & Bullet
 * since 2016-十二月
 */
@Slf4j
public class ConstructorTry {
    public static void main(String[] args) {
        Class<Parent> parentClass = Parent.class;
        try {
            Constructor c1 = parentClass.getConstructor(new Class[]{String.class});
            Constructor c2 = parentClass.getConstructor(new Class[]{int.class, int.class});
            Constructor c3 = parentClass.getConstructor(new Class[]{int.class, int.class, String.class});
           /* System.out.println("c1 Name is ===="+c1.getClass().toString());
            System.out.println("c2 Name is ===="+c2.getClass().toString());
            System.out.println("c3 Name is ===="+c3.getClass().toString());*/
            //获取构造方法参数
            Class[] parameters = c1.getParameterTypes();
            Class[] c3ParameterTypes = c3.getParameterTypes();
            System.out.println("parameter is =====" + parameters);
            for (Class item :
                    c3ParameterTypes) {
                System.out.println("C3 parameter type is" + item.getClass().toString());
            }


            Object o = c2.newInstance(1, 1);
            if (o instanceof Parent) {
                System.out.println("create new object by Java Reflection has succeeded!!!!嘿嘿~~~");
            }
            Parent parentFromConstructor = (Parent) c3.newInstance(1, 2, "hha");

            System.out.println("parent age is " + parentFromConstructor.getParentage());
            System.out.println("Parent Height is " + parentFromConstructor.getParentheight());

        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
}
