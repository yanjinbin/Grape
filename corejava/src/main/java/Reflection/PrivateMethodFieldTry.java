package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通常的观点,从外部访问私有变量和方法是不被允许的,但是借助Java反射机制,你可以做到这一点
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public class PrivateMethodFieldTry {
    public static void main(String[] args) {
        try {
            System.out.println("----尝试获取私有变量-----");
            Parent ganClan = new Parent(2, 23, "ganClan");
            Field parentname = Parent.class.getDeclaredField("parentage");
          //  parentname.setAccessible(true);  去掉也行

            Integer s = (Integer) parentname.get(ganClan);
            System.out.println("filedValue parentName is--------"+s);

            System.out.println("打印私有方法start------");
            Method print = Parent.class.getDeclaredMethod("print", String.class);
            print.setAccessible(true);
            Integer returnValue = (Integer) print.invoke(ganClan, "哈哈哈哈");
            System.out.println("返回值是否默认为1?---------------"+returnValue.equals(new Integer(1)));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
