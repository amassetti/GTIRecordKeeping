/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.RoleMapper;
import edu.gti.asd.ariel.recordkeeping.model.Role;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class RoleDao {
    static Logger log = Logger.getLogger(RoleDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Role> getRoles() {
        String sql = "SELECT * FROM role ORDER BY role_code";
        return jdbcTemplate.query(sql, new RoleMapper());
    }
}
