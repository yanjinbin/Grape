package com.yanjinbin.concurrent;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by yanjinbin on 2017/4/29.
 */
public class HelloDataRepo {

    private ConcurrentHashMap<String, Student> concurrentHashMap;

    public HelloDataRepo() {
        Student student1 = Student.builder().id(1).name("小明").phone("15757538011").build();
        Student student2 = Student.builder().id(2).name("小李").phone("13511453802").build();
        Student student3 = Student.builder().id(3).name("小张").phone("13586272308").build();

        concurrentHashMap.put(student1.getPhone(), student1);
        concurrentHashMap.put(student2.getPhone(), student2);
        concurrentHashMap.put(student3.getPhone(), student3);

    }

    public Student getByPhone(String phone) {
        return concurrentHashMap.get(phone);
    }

    public void changeStudent(Student student) {
        concurrentHashMap.put(student.getPhone(), student);
    }
}
