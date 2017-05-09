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

    private String name;

    volatile int age;

    public Person(String name) {
        this.name = name;
    }
}
