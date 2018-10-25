package com.yanjinbin.aop;

import org.springframework.stereotype.Service;

/**
 * @author xiaobin
 * @since 2018/3/1
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, "+name;
    }
}
