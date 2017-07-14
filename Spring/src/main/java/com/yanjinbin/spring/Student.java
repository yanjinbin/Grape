package com.yanjinbin.spring;

import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 加上下列注解 才能是的mybatis 默认POJO类需要一个默认构造体的时候，
 * 因为单单 加了Builder注解导致的没法进行ORM映射
 *
 * @Author Grape
 * @Since 2017/7/13.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 5)
    private String name;
    @Column(nullable = false, precision = 2)
    private int age;
}
