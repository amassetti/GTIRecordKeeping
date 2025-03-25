/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import static edu.gti.asd.ariel.recordkeeping.utils.SqlHelper.hasColumn;

/**
 *
 * @author ariel
 */
public class CourseMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int i) throws SQLException {
        Course course = new Course();

        if (hasColumn(rs, "course_id")) {
            course.setCourseId(rs.getInt("course_id"));
        }
        
        if (hasColumn(rs, "department_id")) {
            course.setDepartmentId(rs.getInt("department_id"));
        }
        
        if (hasColumn(rs, "department_name")) {
            course.setDepartmentName(rs.getString("department_name"));
        }
        
        if (hasColumn(rs, "course_type_id")) {
            course.setCourseTypeId(rs.getInt("course_type_id"));
        }
        
        if (hasColumn(rs, "course_type")) {
            course.setCourseTypeName(rs.getString("course_type"));
        }
            
        if (hasColumn(rs, "course_code")) {
            course.setCode(rs.getString("course_code"));
        }
            
        if (hasColumn(rs, "name")) {
            course.setName(rs.getString("name"));
        }
            
        if (hasColumn(rs, "description")) {
            course.setDescription(rs.getString("description"));
        }
            
        if (hasColumn(rs, "certification")) {
            course.setCertification(rs.getInt("certification"));
        }
        
        return course;
    }
    
}
