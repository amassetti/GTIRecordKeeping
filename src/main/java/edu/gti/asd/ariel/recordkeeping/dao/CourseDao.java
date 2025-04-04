/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.CourseMapper;
import edu.gti.asd.ariel.recordkeeping.model.Course;
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
    
    public Course getCourseById(Integer courseId) {
        log.info("Getting course by id " + courseId);
        String sql =    "SELECT c.*,\n" +
                        "       d.name as department_name, \n" +
                        "       ct.description as course_type \n" +
                        "FROM course c, department d, course_type ct \n" +
                        "WHERE c.department_id = d.department_id \n" +
                        "AND   c.course_type_id = ct.course_type_id AND c.course_id = ?  ORDER BY d.name, c.name";
        
        Object[] args = {
            courseId
        };
        
        return jdbcTemplate.queryForObject(sql, args, new CourseMapper());
    }
    
    public List<Course> getAllCourses() {
        log.info("Getting all courses");
        String sql =    "SELECT c.*,\n" +
                        "       d.name as department_name, \n" +
                        "       ct.description as course_type \n" +
                        "FROM course c, department d, course_type ct \n" +
                        "WHERE c.department_id = d.department_id \n" +
                        "AND   c.course_type_id = ct.course_type_id ORDER BY d.name, c.name";
        
        return jdbcTemplate.query(sql, new CourseMapper());
    }
    
    public List<Course> searchByCourseName(String courseName) {
        log.info("Getting course by courseName " + courseName);
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
    
    public List<Course> getCoursesByTeacherId(Integer teacherId) {
        log.info("Getting course by teacherid " + teacherId);
        String sql =    "SELECT DISTINCT c.course_id, c.course_code, c.name \n" +
                        "FROM course c, subject_course sc, teacher_subject ts \n" +
                        "WHERE c.course_id = sc.course_id \n" +
                        "AND   sc.subject_id = ts.subject_id \n" +
                        "AND   ts.teacher_id = ?;";

        Object[] args = {
            teacherId
        };
        
        return jdbcTemplate.query(sql, args, new CourseMapper());
    }

    public void insertCourse(Course course) {
        log.info("Inserting course " + course);
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
        log.info("Updating course " + course);
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
        log.info("Deleting course with id " + courseId);
        String sql = "DELETE FROM course WHERE course_id = ?";
        
        Object[] args = {
            courseId
        };
        
        jdbcTemplate.update(sql, args);
        
    }

    public List<Course> getCoursesByCode(String courseCode) {
        log.info("Getting course by code " + courseCode);
        
        String sql =    "SELECT * \n" +
                        "FROM course c \n" +
                        "WHERE c.course_code = ?";

        Object[] args = {
            courseCode
        };
        
        return jdbcTemplate.query(sql, args, new CourseMapper());
    }
    
}
