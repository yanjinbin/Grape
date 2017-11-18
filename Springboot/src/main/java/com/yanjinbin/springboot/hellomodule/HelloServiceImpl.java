package com.yanjinbin.springboot.hellomodule;

import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
public class HelloServiceImpl implements HelloService {
    @Override
    @SneakyThrows(UnsupportedEncodingException.class)
    public String sayHello(String a) {

        String s = new String(a.getBytes(), "utf-8");

        return a + "呀么跌";
    }



}
