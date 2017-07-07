package com.yanjinbin.springboot.AOP;

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
 * @author Silver Bullet
 * @since 三月-10
 */
@Component
@Aspect
@Slf4j
public class WebLogAspect {

    //AspectJ 语法 http://dwz.cn/5uLEWY  http://dwz.cn/5uLHVu

    //定义切点. 在方法执行的时候 切入
   // @Pointcut("excution(public * com.yanjinbin.springboot..*.*(..))")
    public void weblog() {
    }

   // @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //接收到请求,记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //记录下请求内容
        HttpServletRequest request = requestAttributes.getRequest();


        log.info("URL: " + request.getRequestURL().toString());
        log.info("Http Method: " + request.getMethod());
        log.info("IP: " + request.getRemoteAddr());
        log.info("class method:  " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("arguments:  " + Arrays.toString(joinPoint.getArgs()));

    }

    //切点增强  记录请求返回的对象
   // @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求,返回内容
        log.info("response: " + ret);
    }

}
