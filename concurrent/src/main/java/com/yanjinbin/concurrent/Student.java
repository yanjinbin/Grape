package com.yanjinbin.concurrent;

import lombok.Builder;


/**
 * Created by yanjinbin on 2017/4/29.
 */

@Builder
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {
    // private Student(){}
    private Integer id;

    private String name;

    private String phone;
}
