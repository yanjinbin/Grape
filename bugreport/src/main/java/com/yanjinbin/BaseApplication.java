package com.yanjinbin;

import com.yanjinbin.interceptor.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * @author 吉利不布吉
 * @since 2017/11/18
 */
@SpringBootApplication
@ComponentScan("com.yanjinbin")
public class BaseApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
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
