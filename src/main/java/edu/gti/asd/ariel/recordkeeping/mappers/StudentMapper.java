/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class StudentMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        
        if (rs.findColumn("student_id") >= 0) {
            student.setStudentId(rs.getInt("student_id"));
        }
        
        if (rs.findColumn("gender_id") >= 0) {
            student.setGenderId(rs.getInt("gender_id"));
        }
        
        if (rs.findColumn("gender") >= 0) {
            student.setGender(rs.getString("gender"));
        }
        
        if (rs.findColumn("first_name") >= 0) {
            student.setFirstName(rs.getString("first_name"));
        }
        
        if (rs.findColumn("last_name") >= 0) {
            student.setLastName(rs.getString("last_name"));
        }
        
        if (rs.findColumn("email") >= 0) {
            student.setEmail(rs.getString("email"));
        }
        
        if (rs.findColumn("ppsn") >= 0) {
            student.setPpsn(rs.getString("ppsn"));
        }
        
        if (rs.findColumn("address_id") >= 0) {
            Address address = new Address();

            address.setAddressId(rs.getInt("address_id"));
            
            if (rs.findColumn("city_id") >= 0) {
                address.setCityId(rs.getInt("city_id"));
            }
            
            if (rs.findColumn("city_name") >= 0) {
                address.setCity(rs.getString("city_name"));
            }
            
            if (rs.findColumn("address_line_1") >= 0) {
                address.setAddressLine1(rs.getString("address_line_1"));
            }
            
            if (rs.findColumn("address_line_2") >= 0) {
                address.setAddressLine2(rs.getString("address_line_2"));
            }
            
            if (rs.findColumn("eir_code") >= 0) {
                address.setEirCode(rs.getString("eir_code"));
            }
            
            student.setAddress(address);
        }
        
        if (rs.findColumn("course_id") >= 0 && !Integer.valueOf(0).equals(rs.getInt("course_id")) ) {
            Course course = new Course();
            
            if (rs.findColumn("course_id") >= 0) {
                course.setCourseId(rs.getInt("course_id"));
            }
            
            if (rs.findColumn("course_code") >= 0) {
                course.setCode(rs.getString("course_code"));
            }
           
            student.setCourse(course);
        }
        
        return student;
    }
    
}
