/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class StudentsByCourseMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        StudentByCourse studentByCourse = new StudentByCourse();
        
        if (rs.findColumn("registration_date") >= 0) {
            studentByCourse.setRegistrationDate(rs.getDate("registration_date"));
        }
        
        if (rs.findColumn("registration_id") >= 0) {
            studentByCourse.setRegistrationId(rs.getInt("registration_id"));
        }
        
        if (rs.findColumn("student_id") >= 0) {
            studentByCourse.setStudentId(rs.getInt("student_id"));
        }
        
        if (rs.findColumn("first_name") >= 0) {
            studentByCourse.setFirstName(rs.getString("first_name"));
        }
        
        if (rs.findColumn("last_name") >= 0) {
            studentByCourse.setLastName(rs.getString("last_name"));
        }
        
        if (rs.findColumn("email") >= 0) {
            studentByCourse.setEmail(rs.getString("email"));
        }
        
        if (rs.findColumn("course_id") >= 0) {
            studentByCourse.setCourseId(rs.getInt("course_id"));
        }
        
        if (rs.findColumn("course_code") >= 0) {
            studentByCourse.setCourseCode(rs.getString("course_code"));
        }
        
        if (rs.findColumn("course_name") >= 0) {
            studentByCourse.setCourseName(rs.getString("course_name"));
        }
        
        
        return studentByCourse;
    }
    
}
