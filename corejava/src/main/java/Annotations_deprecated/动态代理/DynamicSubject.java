package Annotations_deprecated.动态代理;

import Annotations_deprecated.Preamble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 颜巾斌
 *         Created on 七月 01. tag:windows
 */

public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object sub){
        this.sub=sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Preamble annotation = method.getAnnotation(Preamble.class);
        if (annotation!=null){
            String author = annotation.author();
            String[] names = annotation.names();
            //这里处理逻辑判断
        }
        System.out.println("before calling "+method);
        method.invoke(sub,args);
        System.out.println("after calling "+ method);
        return  null;

    }



}
