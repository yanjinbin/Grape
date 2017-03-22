package com.yanjinbin.springboot.AOP;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
public class AOPAspect {
    @Pointcut(value = "execution(public *.*(..))")
    public void pointTry() {

    }
}
