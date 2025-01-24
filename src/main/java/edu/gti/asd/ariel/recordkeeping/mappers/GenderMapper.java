/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Gender;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class GenderMapper implements RowMapper {
    private static final String GENDER_ID = "gender_id";
    private static final String GENDER_NAME = "gender";

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Gender gender = new Gender();
        
        if (rs.findColumn(GENDER_ID) >= 0) {
            gender.setGenderId(rs.getInt(GENDER_ID));
        }
        
        if (rs.findColumn(GENDER_NAME) >= 0) {
            gender.setGenderName(rs.getString(GENDER_NAME));
        }
        
        return gender;
    }
    
}
