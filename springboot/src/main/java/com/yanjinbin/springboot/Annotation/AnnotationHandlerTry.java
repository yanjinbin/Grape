package com.yanjinbin.springboot.Annotation;

import com.alibaba.fastjson.JSON;

import java.lang.annotation.Annotation;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
public class AnnotationHandlerTry {
    public static void main(String[] args) {
        Class<AnnotationTry> annotationTryClass = AnnotationTry.class;
        System.out.println("annotationed class is ?  "+annotationTryClass);

        System.out.println(annotationTryClass.isAnnotationPresent(MyComponent.class));

        Annotation[] declaredAnnotations = annotationTryClass.getDeclaredAnnotations();
        System.out.println(JSON.toJSONString(declaredAnnotations));
    }
}
