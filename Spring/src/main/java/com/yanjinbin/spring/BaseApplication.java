package com.yanjinbin.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Silver bullet
 * @Since 2017/5/19.
 */
@SpringBootApplication
@EnableAutoConfiguration
//@MapperScan(basePackages = "com.yanjinbin.spring")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }



    //会抛出异常
//    @Bean
//    public  FileInputStream  newBean() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("/nothing");
//        return fileInputStream;
//    }


}
