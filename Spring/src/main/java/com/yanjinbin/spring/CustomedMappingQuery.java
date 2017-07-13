/*
package com.yanjinbin.spring;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

*/
/**
 * @Author Grape
 * @Since 2017/7/13.
 *//*

public class CustomedMappingQuery extends MappingSqlQuery {
    @Override
    protected Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = Student.builder().build();
        student.setId(((Integer) rs.getObject("id")));
        student.setName((rs.getString("name")));
        return student;
    }

    public CustomedMappingQuery(DataSource ds, String sql) {
        super(ds, sql);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
        super.compile();
    }

    public CustomedMappingQuery() {
    }

    public Student getStudent(Integer id){
        CustomedMappingQuery customedMappingQuery = new CustomedMappingQuery();
        Object[] params = new Object[1];
        params[0]=id;
        List execute = customedMappingQuery.execute(params);
    }
}
*/
