/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class TeacherSubjectMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Teacher teacher = new Teacher();
        
        if (rs.findColumn("teacher_id") >= 0) {
            teacher.setTeacherId(rs.getInt("teacher_id"));
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
        
        return teacher;
    }
    
}
