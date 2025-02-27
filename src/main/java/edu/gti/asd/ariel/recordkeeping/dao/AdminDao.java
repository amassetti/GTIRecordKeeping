/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.AdminMapper;
import edu.gti.asd.ariel.recordkeeping.model.Admin;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class AdminDao {
    
    static Logger log = Logger.getLogger(AdminDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Admin> getAllAdmins() {
        log.info("Getting all admins from db...");
        String sql = "SELECT * FROM admin";
        return jdbcTemplate.query(sql, new AdminMapper());
    }
    
}
