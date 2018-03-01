package com.yanjinbin.aop;

import com.yanjinbin.frastructue.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吉利不布吉
 * @since 2018/1/7
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private NeedLogService needLogService;

    @Autowired
    private NormalService normalService;

    @Autowired
    private SomeService someService;

    @RequestMapping(value = "/world")
    @StatsCount
    public Result world(String msg) {
        return Result.Error("错误信息" + msg, 200);
    }

    @RequestMapping("/welcome")
    public Result hello(String name) {
        String hello = helloService.hello(name);
        return Result.Success(hello);
    }

    @RequestMapping("/aop/http/alive")
    public Result alive() {
        return Result.Success("服务一切正常");
    }

    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public Result callSomeInterface() {
        return Result.Success("调用了 user_info 接口.");
    }

    @RequestMapping("/test")
    public void test() {
        needLogService.logMethod("xys");
        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {
            // Ignore
        }
        helloService.hello("哈哈哈哈啊😝");
        normalService.someMethod();
    }



    @RequestMapping("/some")
    public Result some() {
        someService.someMethod();
        return Result.Success("调用SomeService.someMethod()方法成功");

    }
}
