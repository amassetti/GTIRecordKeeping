/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class TeacherMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Teacher teacher = new Teacher();
        
        if (rs.findColumn("teacher_id") >= 0) {
            teacher.setTeacherId(rs.getInt("teacher_id"));
        }
        
        if (rs.findColumn("gender_id") >= 0) {
            teacher.setGenderId(rs.getInt("gender_id"));
        }
        
        if (rs.findColumn("gender") >= 0) {
            teacher.setGender(rs.getString("gender"));
        }
        
        if (rs.findColumn("first_name") >= 0) {
            teacher.setFirstName(rs.getString("first_name"));
        }
        
        if (rs.findColumn("last_name") >= 0) {
            teacher.setLastName(rs.getString("last_name"));
        }
        
        if (rs.findColumn("email") >= 0) {
            teacher.setEmail(rs.getString("email"));
        }
        
        if (rs.findColumn("ppsn") >= 0) {
            teacher.setPpsn(rs.getString("ppsn"));
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
            
            teacher.setAddress(address);

        }
        
        return teacher;
    }
    
}
