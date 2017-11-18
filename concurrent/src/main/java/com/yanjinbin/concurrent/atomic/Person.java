package com.yanjinbin.concurrent.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Silver bullet
 * @Since 2017/5/9.
 */
@Data
@AllArgsConstructor
public class Person {

    volatile int age;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
