package com.yanjinbin.spring;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Grape
 * @Since 2017/7/13.
 */
public interface StudentMapper {

    @Select("SELECT * FROM Studen WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO Student(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}


