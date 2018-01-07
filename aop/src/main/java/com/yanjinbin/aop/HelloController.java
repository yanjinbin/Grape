package com.yanjinbin.aop;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yanjinbin.frastructue.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 吉利不布吉
 * @since 2018/1/7
 */
@RestController
@RequestMapping
public class HelloController {
    @RequestMapping("/hello")
    public Result  hello(){
        return Result.PAGE(111, 2, Lists.newArrayList(11, 123, 444, 1111));
    }

    @RequestMapping("/world")
    public Result world(){
        return Result.Error("ahshhs",200);
    }

    @RequestMapping("/code")
    public Result code(){
        return Result.Success(Lists.newArrayList("1222","aacc",1000L));
    }


    @RequestMapping("/more")
    public Result hasMore(){
        Map map = Maps.newHashMap();
        map.put("12","aaa");
        map.put("bbb","cccc");
        return Result.SuccessExt("h哈哈哈",200, map);
    }
}
