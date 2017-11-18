package com.yanjinbin.springboot.hellomodule;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Mapper
public interface HelloMapper {
    int update();
}
