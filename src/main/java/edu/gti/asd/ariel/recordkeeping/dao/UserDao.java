/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.UserMapper;
import edu.gti.asd.ariel.recordkeeping.model.User;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ariel
 */

@Repository
public class UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    static Logger log = Logger.getLogger(UserDao.class.getName());
    
    public Optional<User> getUserByUsername(String username) {
        log.info("Fetching user from database with username " + username);
        String sql = "SELECT * FROM user u, role r WHERE u.role_id = r.role_id AND username=?";
        Object[] args = new Object[]{username};
        List<User> users = jdbcTemplate.query(sql, args, new UserMapper());
        log.info("Results: " + users);
        User user = (users != null && !users.isEmpty()) ? users.get(0) : null;
        return Optional.ofNullable(user);
    }

    public void registerUser(User user) {
        log.info("Registering user " + user);
        String sql = "INSERT INTO user (role_id, username, password, teacher_id, student_id, admin_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        Object[] args = {
            user.getRoleId(),
            user.getUsername(),
            user.getPassword(),
            user.getTeacherId(),
            user.getStudentId(),
            user.getAdminId()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public List<User> getUsers() {
        log.info("Fetching all users from db");
        String sql = "SELECT * FROM user u, role r WHERE u.role_id = r.role_id";
        return jdbcTemplate.query(sql, new UserMapper());
    }
    
    public void updateUser(User user) {
        log.info("Updating user " + user);
        
        String sql = "UPDATE user\n" +
            "SET\n" +
            "role_id = ?,\n" +
            "username = ?,\n" +
            "password = ?,\n" +
            "teacher_id = ?,\n" +
            "student_id = ?,\n" +
            "admin_id = ?\n" +
            "WHERE user_id = ?";
        
        Object[] args = {
            user.getRoleId(),
            user.getUsername(),
            user.getPassword(),
            user.getTeacherId(),
            user.getStudentId(),
            user.getAdminId(),
            user.getUserId()
        };
        
//        log.info(sql);
//        log.info("args: " + user.toString());
        
        jdbcTemplate.update(sql, args);
        
    }
    
}
