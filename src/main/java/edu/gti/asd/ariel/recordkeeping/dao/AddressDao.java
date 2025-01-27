/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.model.Address;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

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
        String sql = "INSERT INTO address (address_id, city_id, address_line_1, address_line_2, eir_code) VALUES (?, ?, ?, ?, ?);";
        
        Object[] args = {
            address.getAddressId(),
            address.getCityId(),
            address.getAddressLine1(),
            address.getAddressLine2(),
            address.getEirCode()
        };
        
        return jdbcTemplate.update(sql, args);
    }
    
}
