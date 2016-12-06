package Annotations;

import java.lang.annotation.*;

/**
 * @author Silver & Bullet
 *         since 2016-十二月
 * @ AT 是annotation type的意思
 */
@Target(ElementType.TYPE)//目标范围 类型
@Retention(RetentionPolicy.RUNTIME)//运行时有效
@Documented
public @interface Preamble {

    String author() default "Silver & Bullet";

    String[] names() default {"heiHei", "aaa"};//java数组默认值 数组

}
