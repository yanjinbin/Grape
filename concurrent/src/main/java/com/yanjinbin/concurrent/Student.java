package com.yanjinbin.concurrent;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Grape
 * @Since 2017/7/5.
 */
@Builder
@Data
public class Student {

    private int age;

    private String name;

    private int id;
}
