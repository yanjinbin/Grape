package com.yanjinbin.springboot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吉利不布吉
 * @since 2018/2/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Value {
    private String m;
    private String n;
}
