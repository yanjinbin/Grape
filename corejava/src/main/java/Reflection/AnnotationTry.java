/*
package Reflection;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

*/
/**
 * @author Silver & Bullet
 *         since 2016-十二月
 *//*

public class AnnotationTry {
    public static void main(String[] args) {
        System.out.println("--------进入annotation实践--------");
        Annotation[] annotations = Parent.class.getAnnotations();
        Method[] methods = Parent.class.getMethods();
        for (Method item :
                methods) {
            Annotation[][] parameterAnnotations = item.getParameterAnnotations();
            for (Annotation[] annotationArray :
                    parameterAnnotations) {
                for (Annotation annotation :annotationArray
                     ) {
                    if (annotation instanceof SuppressWarnings) {
                        System.out.println("value值-----"+((SuppressWarnings) annotation).value());
                    }
                }
            }

        }

        for (Annotation item :
                annotations) {
            System.out.println(item.getClass().getName());
            if (item instanceof Preamble) {
                Preamble preamble = (Preamble) item;
                String[] names = preamble.names();
                for (String s :
                        names) {
                    System.out.println("-------"+s);
                }
                System.out.println("author"+preamble.author());
            }
        }
    }
}
*/
