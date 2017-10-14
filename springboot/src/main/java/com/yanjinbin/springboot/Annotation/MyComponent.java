package com.yanjinbin.springboot.Annotation;

import org.springframework.stereotype.Component;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
@Documented
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MyComponent {
    String value() default "";
}
