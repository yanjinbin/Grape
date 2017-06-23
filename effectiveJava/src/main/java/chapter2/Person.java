package chapter2;

import lombok.Builder;

/**
 * 利用 builder 风格 来解决 构造器多参数问题，避免 P9的丑陋写法
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
@Builder
public class Person {
    public String name;
    public int age;
    public long height;
}
