package com.yanjinbin.spring;

import lombok.*;

/**
 * 加上下列注解 才能是的mybatis 默认POJO类需要一个默认构造体的时候，
 * 因为单单 加了Builder注解导致的没法进行ORM映射
 * @Author Grape
 * @Since 2017/7/13.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
}
