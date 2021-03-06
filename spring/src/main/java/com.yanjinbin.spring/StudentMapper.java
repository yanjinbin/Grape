package com.yanjinbin.spring;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author Grape
 * @Since 2017/7/13.
 */
@Mapper
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO " +
            "student (name, age,gmt_create,gmt_modified) " +
            "VALUES " +
            "('XXX','100','2017-07-16 20:34:51','2017-07-16 20:34:51'),(#{name}, #{age},#{gmt_create},#{gmt_modified})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("gmt_create") Date gmt_Create, @Param("gmt_modified") Date gmt_modified);

    @Delete("delete from student where name = #{name}")
    int deleteByName(String name);



}


