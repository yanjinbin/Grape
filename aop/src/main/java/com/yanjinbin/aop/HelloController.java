package com.yanjinbin.aop;

import com.yanjinbin.frastructue.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吉利不布吉
 * @since 2018/1/7
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/world",method = RequestMethod.PUT)
    public Result world(String msg){
        return Result.Error("错误信息"+msg,200);
    }

}
