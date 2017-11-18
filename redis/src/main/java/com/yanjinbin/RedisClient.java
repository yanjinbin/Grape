package com.yanjinbin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Silver Bullet
 * @since 十二月-28
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //------------------------------------ start--------------------------------
    // key-value   =  String-Object  start
    public void set(String key, Object value, Integer expiredTime) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
        redisTemplate.expire(key, expiredTime, TimeUnit.SECONDS);
    }


    public void set(RedisKey redisKey, String key, Object value) {
        String rawKey = redisKey.getPrefix() + key;
        set(key, value, redisKey.getExpiredTime());
    }


    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String rawKey) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object value = valueOperations.get(rawKey);
        return value;
    }

    public Object get(RedisKey redisKey, String key) {
        String rawKey = redisKey.getPrefix().concat(key);
        Object value = redisTemplate.opsForValue().get(rawKey);
        return value;
    }

    public Boolean hasKey(String rawKey) {
        return redisTemplate.hasKey(rawKey);
    }

    public Boolean hasKey(RedisKey redisKey, String key) {
        return hasKey(redisKey.getPrefix().concat(key));
    }

    public Long fetchTTL(String rawKey) {
        Long expire = redisTemplate.getExpire(rawKey);
        return expire;
    }

    public Long fetchTTL(RedisKey redisKey, String key) {
        Long expire = redisTemplate.getExpire(redisKey.getPrefix().concat(key));
        return expire;
    }

    public Boolean expiredAt(String rawKey, Date date) {
        Boolean isValid = redisTemplate.expireAt(rawKey, date);
        return isValid;
    }

    public Boolean expiredAt(RedisKey redisKey, String key, Date date) {
        String rawKey = redisKey.getPrefix().concat(key);
        return expiredAt(rawKey, date);
    }


    public void delete(String rawKey) {
        if (hasKey(rawKey)) {
            redisTemplate.delete(rawKey);
        }
    }

    public void delete(RedisKey redisKey, String key) {
        String rawKey = redisKey.getPrefix().concat(key);
        delete(rawKey);
    }


    public RedisResult<Long> set2Set(String rawKey, Object value) {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        Long add = setOperations.add(rawKey, value);//return num of  total values
        if (add != 1) {
            return RedisResult.createError("添加元素:" + value.getClass().getName() + "失败");
        }
        return RedisResult.create(add, "成功");
    }

    public void incr(String rawKey) {
        Long increment = redisTemplate.opsForValue().increment(rawKey, 1);

    }
}
