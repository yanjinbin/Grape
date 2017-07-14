package chapter6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class RunTest {
    public static void main(String[] args) {
        Herb herb = new Herb(Herb.Type.ANNUAL.name(), Herb.Type.ANNUAL);
        Method[] declaredMethods = herb.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Override.class)) {
                try {
                    Object invoke = method.invoke(herb, herb.type);
                    System.out.println(invoke);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
