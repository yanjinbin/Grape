package com.yanjinbin.springboot.hellomodule;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where name =#{name}")
    User findById(@Param("name") String name);


    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);


}
