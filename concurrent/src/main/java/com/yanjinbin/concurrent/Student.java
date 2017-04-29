package com.yanjinbin.concurrent;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by yanjinbin on 2017/4/29.
 */

@Data
@Builder
@Accessors(chain = true)
public class Student {
    private Integer id;

    private String name;

    private String phone;
}
