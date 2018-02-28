package com.yanjinbin.springboot;

import com.yanjinbin.frastructue.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author 吉利不布吉
 * @since 2018/2/28
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result get(String v) {
        return Result.Success(v, "GET 方法成功");
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Result post(@RequestBody Value v, @RequestParam String msg) {
        return Result.Success(v.getM() + v.getN()+msg, "POST 方法成功");
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public Result put(String v) {
        return Result.Success(v, "PUT 方法成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(String v) {
        return Result.Success(v, "DELETE 方法成功");
    }

}
