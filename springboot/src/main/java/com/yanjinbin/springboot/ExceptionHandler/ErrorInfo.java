package com.yanjinbin.springboot.ExceptionHandler;

import lombok.Data;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    private String url;
    private T data;
    // 省略getter和setter
}