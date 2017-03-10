package com.yanjinbin.springboot.hellomodule;

import com.yanjinbin.springboot.Util.ViewResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@RestController
@RequestMapping("/hello/")
public class HelloWorldController {

    @RequestMapping(value = "world")
    public ViewResult hello(HttpServletRequest request, HttpServletResponse response,String a) throws IOException {
        response.setHeader("x-xcrf-token","1111");
        response.sendRedirect("localhost:8080/user/get/1");
        response.setStatus(HttpStatus.OK.value());
        return ViewResult.createSuccess(a, "你大爷");
    }
}
