package com.yanjinbin.concurrent;

import lombok.Builder;
import lombok.Data;


/**
 * Created by yanjinbin on 2017/4/29.
 */
@Data
@Builder
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {
    // private Student(){}
    private Integer id;

    private String name;

    private String phone;
}
