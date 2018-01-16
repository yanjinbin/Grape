package com.yanjinbin;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.yanjinbin.interceptor.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;

/**
 * @author 吉利不布吉
 * @since 2017/11/18
 */
@SpringBootApplication(scanBasePackages = {"com.yanjinbin"})
@ComponentScan("com.yanjinbin")
public class BugReportApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(BugReportApplication.class, args);
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

    @Bean
    public HttpMessageConverter httpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setDefaultCharset(Charsets.UTF_8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON_UTF8));
        return fastJsonHttpMessageConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(httpMessageConverter());
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
