package com.yanjinbin.aop;

import com.yanjinbin.frastructue.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobin
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

    // 最常用的AOP实现
    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public Result callSomeInterface() {
        return Result.Success("调用了 user_info 接口.");
    }

    // 方法前后切面
    @RequestMapping("/test")
    public void test() {
        needLogService.logMethod("xys");
        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {
            // Ignore
        }
        System.out.println(helloService.hello("哈哈哈哈啊😝"));
        normalService.someMethod();
    }

    // 统计方法耗时
    @RequestMapping("/some")
    public Result some() {
        someService.someMethod();
        return Result.Success("调用SomeService.someMethod()方法成功");

    }
}
