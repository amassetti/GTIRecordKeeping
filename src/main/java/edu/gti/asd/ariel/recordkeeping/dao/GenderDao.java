/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.GenderMapper;
import edu.gti.asd.ariel.recordkeeping.model.Gender;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ariel
 */

@Repository
public class GenderDao {
    static Logger log = Logger.getLogger(GenderDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Gender> getGenders() {
        String sql = "SELECT * FROM gender ORDER BY gender";
        return jdbcTemplate.query(sql, new GenderMapper());
    }
    
}
