package com.yanjinbin.spring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 需要好好理解以下几个类 ProxyFactoryBean  ReflectiveMethodInterceptor AopProxy  getObject() proceed() AdviceSupport   JDK OR CGLIB  AopProxy invoke() 方法 MethodPointCunt MethodMatcher
 *
 * @Author Silver bullet
 * @Since 2017/5/31.
 *
 */


@Aspect
@Component
@Slf4j
public class WebLogAspect {

    // 定位切点
    @Pointcut("execution(public * com.yanjinbin.spring.*.*(..))")
    public void weblog() {
    }

    // 锚定切点的 advice
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url is \t" + request.getRequestURL());
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void afterReturning(Object ret) {
        log.info("response:\t" + ret);
    }

}
