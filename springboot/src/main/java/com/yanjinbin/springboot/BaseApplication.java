package com.yanjinbin.springboot;

import com.yanjinbin.springboot.interceptor.BaseInterceptor;
import com.yanjinbin.springboot.interceptor.TestFilter1;
import com.yanjinbin.springboot.interceptor.TestFilter2;
import com.yanjinbin.springboot.interceptor.TestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

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
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(filter1());
        register.setOrder(1);
        register.setFilter(filter2());
        register.setOrder(2);
        return register;

    }


    @Bean
    public Filter filter1() {
        return new TestFilter1();
    }

    @Bean
    public Filter filter2() {
        return new TestFilter2();
    }


}
