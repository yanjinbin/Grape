package Annotations.动态代理;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * 参考链接 https://goo.gl/ShfsVe
 * 链接:http://blog.csdn.net/liangbinny/article/details/18656791
 * 和反射机制的结合
 * 通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变(替换)，需要控制的接口(Subject接口)可以在运行时改变，控制的方式(DynamicSubject类)也可以动态改变，从而实现了非常灵活的动态代理关系
 *
 * @author 颜巾斌
 *         Created on 七月 01. tag:windows
 */

public class Client {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicSubject(realSubject);
        Class cls = realSubject.getClass();

        //利用java.lang.reflect.Proxy 你可以动态创建接口的实现


        //1 类加载器 2要实现的接口数组
        Class c = Proxy.getProxyClass(cls.getClassLoader(), cls.getInterfaces());
        Constructor ct = null;
        try {
            //3 一个InvocationHadnler 把所有的方法调用都转到了代理上了
            ct = c.getConstructor(new Class[]{InvocationHandler.class});

            //handler对象指向的是dynamicSubject 因此
            Subject subject = ((Subject) ct.newInstance(new Object[]{handler}));
            subject.request();//当调用此方法的时候,dynamicSubject代理了Subject的实现→realSubject
            //因此方法会进入InvocationHandler的 invoke方法 ,此方法代理了 Subject接口的实现
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //以下是一次性生成
       /* Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(), handler);
        subject.request();*/
    }
}
