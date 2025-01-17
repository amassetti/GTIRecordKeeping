/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class CourseMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Course course = new Course();

        if (rs.findColumn("course_id") >= 0)
            course.setCourseId(rs.getInt("course_id"));
        
        course.setDepartmentId(rs.getInt("department_id"));
        course.setDepartmentName(rs.getString("department_name"));
        course.setCourseTypeId(rs.getInt("course_type_id"));
        course.setCourseTypeName(rs.getString("course_type"));
        course.setCode(rs.getString("course_code"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setCertification(rs.getInt("certification"));
        
        return course;
    }
    
}
