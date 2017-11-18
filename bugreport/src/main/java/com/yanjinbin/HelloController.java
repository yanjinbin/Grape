package com.yanjinbin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/npe")
    public void throwNPE() {
        helloService.throwNPE(null);
    }

    @RequestMapping("/catch_npe")
    public void catchNPE() {
        try {
            helloService.throwNPE(null);
        } catch (Exception e) {
            log.error("异常堆栈信息----- {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
