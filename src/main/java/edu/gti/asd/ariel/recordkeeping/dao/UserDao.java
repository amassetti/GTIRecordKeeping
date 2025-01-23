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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class UserDao {
    
    private JdbcTemplate jdbcTemplate;
    static Logger log = Logger.getLogger(UserDao.class.getName());

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Optional<User> getUserByUsername(String username) {
        String sql = "SELECT * FROM user u, role r WHERE u.role_id = r.role_id AND username=?";
        Object[] args = new Object[]{username};
        List<User> users = jdbcTemplate.query(sql, args, new UserMapper());
        log.info("Results: " + users);
        User user = (users != null && !users.isEmpty()) ? users.get(0) : null;
        return Optional.ofNullable(user);
    }
    
}
