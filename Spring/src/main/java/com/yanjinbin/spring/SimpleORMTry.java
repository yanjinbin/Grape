package com.yanjinbin.spring;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.util.List;

/**
 * @Author Grape
 * @Since 2017/7/14.
 */
public class SimpleORMTry {
//    public static void main(String[] args) {
//        try {
//            System.out.println(getStudent(11));
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public static Student getStudent(Integer id) throws NotFoundException {
        CustomerMappingQuery customerMappingQuery = new CustomerMappingQuery(null);
        Object[] params = new Object[1];
        params[0] = id;
        List rs = customerMappingQuery.execute(params);
        if (rs.size() > 0) {
            return ((Student) rs.get(0));
        } else throw new NotFoundException("差无结果");
    }
}
