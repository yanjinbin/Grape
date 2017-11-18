package com.yanjinbin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * http://blog.didispace.com/sjpringbootredis/
 *
 * @Author Grape
 * @Since 2017/7/11.
 */
public class RedisTry {
    @Autowired
    private RedisTemplate redisTemplate;



}
