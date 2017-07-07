package com.yanjinbin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @Author Grape
 * @Since 2017/7/7.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(String name, Integer age) {
        LocalDateTime ldt = LocalDateTime.now();
        Date now = Date.from(ldt.toInstant(ZoneOffset.UTC));
        return jdbcTemplate.update("insert into student(name,age,gmt_create,gmt_modified) VALUES (?,?,?,?)", name, age,now,now);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE  FROM student WHERE  name = ? ", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from student", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM student ");

    }
}
