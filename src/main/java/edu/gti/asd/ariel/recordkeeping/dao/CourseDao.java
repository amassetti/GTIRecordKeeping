/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.CourseMapper;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.Student;
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
public class CourseDao {
    
    static Logger log = Logger.getLogger(CourseDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Course> getAllCourses() {
        String sql =    "SELECT c.*,\n" +
                        "       d.name as department_name, \n" +
                        "       ct.description as course_type \n" +
                        "FROM course c, department d, course_type ct \n" +
                        "WHERE c.department_id = d.department_id \n" +
                        "AND   c.course_type_id = ct.course_type_id ORDER BY d.name, c.name";
        
        return jdbcTemplate.query(sql, new CourseMapper());
    }
    
    public List<Course> searchByCourseName(String courseName) {
        String sql =    "SELECT c.*,\n" +
                        "       d.name as department_name, \n" +
                        "       ct.description as course_type \n" +
                        "FROM course c, department d, course_type ct \n" +
                        "WHERE c.department_id = d.department_id \n" +
                        "AND   c.course_type_id = ct.course_type_id AND c.name LIKE ?  ORDER BY d.name, c.name";
        
        Object[] args = {
            "%" + courseName + "%"
        };
        
        return jdbcTemplate.query(sql, args, new CourseMapper());
    }

    public void insertCourse(Course course) {
        String sql = "INSERT INTO course (department_id, course_type_id, course_code, name, description, certification)\n" +
                     "VALUES (?,?,?,?,?,?)";
        
        Object[] args = {
            course.getDepartmentId(),
            course.getCourseTypeId(),
            course.getCode(),
            course.getName(),
            course.getDescription(),
            course.getCertification()
        };
        
        jdbcTemplate.update(sql, args);
        
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE course\n" +
                        "SET\n" +
                        "department_id = ?,\n" +
                        "course_type_id = ?,\n" +
                        "course_code = ?,\n" +
                        "name = ?,\n" +
                        "description = ?,\n" +
                        "certification = ?\n" +
                        "WHERE course_id = ?";
        
        Object[] args = {
            course.getDepartmentId(),
            course.getCourseTypeId(),
            course.getCode(),
            course.getName(),
            course.getDescription(),
            course.getCertification(),
            course.getCourseId()
        };
        
        jdbcTemplate.update(sql, args);
        
    }

    public void deleteCourse(Integer courseId) {
        String sql = "DELETE FROM course WHERE course_id = ?";
        
        Object[] args = {
            courseId
        };
        
        jdbcTemplate.update(sql, args);
        
    }
    
    public Integer registerStudent(Course course, Student student) {
        Integer registrationId = null;
        
        
        
        return registrationId;
    }
    
}
