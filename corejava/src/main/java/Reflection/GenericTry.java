package Reflection;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Java 泛型 反射获取信息 ,虽然说java在编译器,通过泛型消除了强制转换和进行类型检查
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class GenericTry<K> {

    public static void main(String[] args) {
        try {
            //获取泛型方法返回类型
            Method method = GenericTry.class.getMethod("getStringList");//获取制定的参数
            /**
             * If the return type is a parameterized type,
             * the {@code Type} object returned must accurately reflect
             * the actual type parameters used in the source code.
             *
             * <p>If the return type is a type variable or a parameterized type, it
             * is created. Otherwise, it is resolved.
             */
            Type genericReturnType = method.getGenericReturnType();//获取泛型化的返回类型
            if (genericReturnType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericReturnType;
                Type[] actualTypeArguments = type.getActualTypeArguments();
                System.out.println("长度是------"+actualTypeArguments.length);
                for (Type item:actualTypeArguments){
                    Class typeArgClass = (Class) item;
                    System.out.println("TypeArgClass is -------------"+typeArgClass);//int[] 数组
                }
            }

            //获取泛型方法参数类型
            Method setStringListMethod = GenericTry.class.getMethod("setStringList", List.class);
            System.out.println(setStringListMethod.getName());
            Type[] genericParameterTypes = setStringListMethod.getGenericParameterTypes();
            for (Type type :
                    genericParameterTypes) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualParameterArguments = parameterizedType.getActualTypeArguments();
                    for (Type item:actualParameterArguments){
                        Class aClass = (Class) item;
                        System.out.println("parameterArgClass =  "+item);
                    }

                }
            }


            //获取公有 泛型变量类型
            Field stringList = GenericTry.class.getField("stringList");
            Type genericType = stringList.getGenericType();
            if (genericType instanceof  ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type item :
                        actualTypeArguments) {
                    Class aClass = (Class) item;
                    System.out.println("Parameterized Field Arg is "+ aClass.getName());
                }
            }

            //java获取  泛型失败(特意和泛型化参数失败)
            System.out.println("Reflection fetch generic type ");
            Method fun = GenericTry.class.getMethod("fun");
            Type genericReturnType1 = fun.getGenericReturnType();
            if (genericReturnType1 instanceof ParameterizedType){//instanceof   为false
                ParameterizedType genericReturnType11 = (ParameterizedType) genericReturnType1;
                Type[] actualTypeArguments = genericReturnType11.getActualTypeArguments();
                for (Type item :
                        actualTypeArguments) {
                    System.out.println(item.getTypeName());
                }
            }

        } catch (NoSuchMethodException e) {
        //    e.printStackTrace();
        } catch (NoSuchFieldException e) {
        //    e.printStackTrace();
        }
    }

    public List<String> stringList;

    public static String[] array1 = {"a", "b", "c", "d", "e", "f"};

    public K fun() {
        return null;
    }

    public List<String> getStringList() {
        return Lists.newArrayList(array1);
    }

    public void setStringList(List<String> list){
        List<String> stringList = getStringList();
        stringList=list;
    }
}
