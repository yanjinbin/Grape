package com.yanjinbin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.yanjinbin.springboot")
public class BaseApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GeneralInterceptor()).addPathPatterns("/user/");
    }
}
