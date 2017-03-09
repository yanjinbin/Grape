package com.yanjinbin.springboot.hellomodule;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String a) {
        return a + "呀么跌";
    }
}
