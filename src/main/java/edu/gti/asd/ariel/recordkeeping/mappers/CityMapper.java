/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class CityMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        City city = new City();
        
        if (rs.findColumn("city_id") >= 0) {
            city.setCityId(rs.getInt("city_id"));
        }
        
        if (rs.findColumn("city_name") >= 0) {
            city.setCityName(rs.getString("city_name"));
        }
        
        if (rs.findColumn("county") >= 0) {
            city.setCounty(rs.getString("county"));
        }
        
        return city;        
                
    }
    
}
