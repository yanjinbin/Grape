package com.yanjinbin.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiaobin
 * @since 2018/3/1
 */
@Aspect
@Component
public class StatsAspect {
    @Pointcut("execution(* com.yanjinbin.aop.HelloController.*(..))")
    public void statsCountOperation() {
        System.out.println("执行@PointCut标注的方法");
    }
}
