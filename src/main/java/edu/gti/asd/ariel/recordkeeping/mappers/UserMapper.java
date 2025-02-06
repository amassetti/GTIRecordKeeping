/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        
        if (rs.findColumn("user_id") > -1)
            user.setUserId(rs.getInt("user_id"));
        
        if (rs.findColumn("role_id") > -1)
            user.setRoleId(rs.getInt("role_id"));
        
        if (rs.findColumn("username") > -1)
            user.setUsername(rs.getString("username"));
        
        if (rs.findColumn("password") > -1)
            user.setPassword(rs.getString("password"));
        
        if (rs.findColumn("student_id") > -1)
            user.setStudentId(rs.getInt("student_id"));
        
        if (rs.findColumn("teacher_id") > -1)
            user.setTeacherId(rs.getInt("teacher_id"));
        
        if ( rs.findColumn("admin_id") > -1 )
            user.setAdminId(rs.getInt("admin_id"));
        
        if (rs.findColumn("role_code") > -1)
            user.setRole(rs.getString("role_code"));
        
        return user;
    }
    
}
