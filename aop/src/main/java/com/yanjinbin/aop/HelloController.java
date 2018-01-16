package com.yanjinbin.aop;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yanjinbin.frastructue.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 吉利不布吉
 * @since 2018/1/7
 */
@RestController
@RequestMapping("/demo")
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Result  hello(String msg){
        List list = Lists.newArrayList();
        list.add(msg);
        list.add("1111");
        return Result.PAGE(111, 2,list);
    }

    @RequestMapping(value = "/world",method = RequestMethod.PUT)
    public Result world(String msg){
        return Result.Error("错误信息"+msg,200);
    }

    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public Result code(String msg,Integer i){
        List list = Lists.newArrayList();
        list.add("1222");
        list.add(msg);
        list.add(i);
        return Result.Success(list);
    }


    @RequestMapping(value = "/more",method = RequestMethod.DELETE)
    public Result hasMore(String msg,Integer i){
        Map map = Maps.newHashMap();
        map.put("12","aaa");
        map.put("bbb","cccc");
        map.put("deleteStr",msg);
        map.put("deleteInt",i);
        return Result.SuccessExt("h哈哈哈",200, map);
    }
}
