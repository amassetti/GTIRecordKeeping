/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.model.Address;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author ariel
 */
public class AddressDao {
    static Logger log = Logger.getLogger(AddressDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Integer insertAddress(Address address) {
        String sql = "INSERT INTO address (city_id, address_line_1, address_line_2, eir_code) VALUES (?, ?, ?, ?);";
        
//        Object[] args = {
//            address.getCityId(),
//            address.getAddressLine1(),
//            address.getAddressLine2(),
//            address.getEirCode()
//        };
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setInt(1, address.getCityId());
            ps.setString(2, address.getAddressLine1());
            ps.setString(3, address.getAddressLine2());
            ps.setString(4, address.getEirCode());
            return ps;
        }, keyHolder);
        
        
        //return jdbcTemplate.update(sql, args);
        
        return keyHolder.getKey().intValue();
    }
    
}
