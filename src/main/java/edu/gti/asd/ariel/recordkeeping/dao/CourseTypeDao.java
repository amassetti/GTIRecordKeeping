/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.CourseTypeMapper;
import edu.gti.asd.ariel.recordkeeping.model.CourseType;
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
public class CourseTypeDao {
    
    static Logger log = Logger.getLogger(CourseTypeDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<CourseType> getCourseTypes() {
        String sql = "SELECT * FROM course_type";
        return jdbcTemplate.query(sql, new CourseTypeMapper());
    }
    
}
