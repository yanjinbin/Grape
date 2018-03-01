package com.yanjinbin.aop;

import org.springframework.stereotype.Service;

/**
 * @author 吉利不布吉
 * @since 2018/3/1
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, "+name;
    }
}
