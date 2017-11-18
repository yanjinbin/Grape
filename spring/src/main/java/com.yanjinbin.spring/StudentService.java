package com.yanjinbin.spring;

/**
 * @Author Grape
 * @Since 2017/7/7.
 */
public interface StudentService {
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    int create(String name, Integer age);
    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);
    /**
     * 获取用户总量
     */
    Integer getAllUsers();
    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
