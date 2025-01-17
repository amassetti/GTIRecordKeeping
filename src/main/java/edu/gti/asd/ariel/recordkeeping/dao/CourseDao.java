/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.CourseMapper;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class CourseDao {
    
    static Logger log = Logger.getLogger(CourseDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

    public List<Course> getAllCourses() {
        String sql =    "SELECT c.*,\n" +
                        "       d.name as department_name, \n" +
                        "       ct.description as course_type \n" +
                        "FROM course c, department d, course_type ct \n" +
                        "WHERE c.department_id = d.department_id \n" +
                        "AND   c.course_type_id = ct.course_type_id";
        
        return jdbcTemplate.query(sql, new CourseMapper());
    }

    public void insertCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteCourse(Integer courseId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
