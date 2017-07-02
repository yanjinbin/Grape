package Annotations_deprecated.动态代理;

/**
 * @author 颜巾斌
 *         Created on 七月 01. tag:windows
 */

public class RealSubject implements Subject {
    public void request() {
        System.out.println("动态代理中");
    }
}
