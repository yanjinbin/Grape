package com.yanjinbin.spring;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


/**
 * @Author Grape
 * @Since 2017/7/13.
 */
public class CustomerMappingQuery extends MappingSqlQuery {

    public CustomerMappingQuery(DataSource ds) {
        super(ds, "SELECT  id ,name from student where id = ?");
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
        compile();
    }


    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(((Integer) rs.getObject("id"))
        );
        student.setName(rs.getString("name"));
        return student;
        // return null;
    }
}
