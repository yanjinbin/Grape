package com.yanjinbin.springboot.hellomodule;

import lombok.Builder;
import lombok.Data;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Data
@Builder
public class User {

    private Integer id;
    private Integer age;
    private String name;
    public User( Integer id,Integer age, String name) {

        this.age = age;
        this.id = id;
        this.name = name;
    }
}
