package Reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * Created by Silver & Bullet
 * since 2016-十二月
 */
@Slf4j
public class FieldTry {
    public static void main(String[] args) {
        System.out.println("setter getter for fields by Reflection");
        Class<Parent> parentClass = Parent.class;
       /* boolean isPrimitive = parentClass.isPrimitive();
        System.out.println(isPrimitive);
        System.out.println(int.class.isPrimitive());*/
        Field[] fields = parentClass.getFields();//return all the public fields or interfaces fields
        for (Field item :
                fields) {
            System.out.println(item.getName());
        }

        try {
            Field family_name = parentClass.getField("Family_Name");
            Class<?> type = family_name.getType();

            //获取指定 名称的 public field 的成员变量
            System.out.println("family_name is "+family_name);
            System.out.println("family_type is "+type);

            //getter和setter方法设置

        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e.getClass());
            //   e.printStackTrace();
        }

    }
}
