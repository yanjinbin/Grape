package com.yanjinbin.springboot.RedisUtil;


import lombok.Getter;

/**
 * @author Silver Bullet
 * @since 十二月-28
 */

public enum RedisKey {

    ;
    @Getter
    private String prefix;
    @Getter
    private Integer expiredTime;

    RedisKey(String prefix, Integer expiredTime) {
        this.prefix = prefix;
        this.expiredTime = expiredTime;
    }
}
