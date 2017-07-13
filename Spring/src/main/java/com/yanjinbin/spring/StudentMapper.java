package com.yanjinbin.spring;

import org.apache.ibatis.annotations.*;

import java.util.Date;

/**
 * @Author Grape
 * @Since 2017/7/13.
 */
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO " +
            "student (name, age,gmt_create,gmt_modified) " +
            "VALUES " +
            "(#{name}, #{age},#{gmt_create},#{gmt_modified})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("gmt_create") Date gmt_Create, @Param("gmt_modified") Date gmt_modified);

    @Delete("delete from student where name = #{name}")
    int deleteByName(String name);

}


