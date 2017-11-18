package com.yanjinbin.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Silver bullet
 * @Since 2017/5/31.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return "hello\t" + name;
    }
}
