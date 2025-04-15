/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.StudentMapper;
import edu.gti.asd.ariel.recordkeeping.mappers.StudentsByCourseMapper;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
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
public class StudentDao {
    static Logger log = Logger.getLogger(StudentDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final int NOT_PAID = 0;

    public List<Student> getStudents() {
        log.info("Getting all students from DB");
        
        String sql = """
            SELECT
                s.student_id,
                s.first_name,
                s.last_name,
                s.email,
                s.ppsn,
                g.*,
                a.*,
                c.*,
                crs.course_id,
                crs.course_code,
                crs.name as course_name
            FROM student s
            INNER JOIN gender g ON s.gender_id = g.gender_id
            INNER JOIN address a ON s.address_id = a.address_id
            INNER JOIN city c ON c.city_id = a.city_id
            LEFT JOIN student_course sc on sc.student_id = s.student_id
            LEFT JOIN course crs on sc.course_id = crs.course_id
        """;
        
        return jdbcTemplate.query(sql, new StudentMapper());
    }
    
    
    public List<Student> searchStudents(String filter) {
        log.info("Searching students with filter " + filter);
        
        String sql = """
            SELECT
                s.student_id,
                s.first_name,
                s.last_name,
                s.email,
                s.ppsn,
                g.*,
                a.*,
                c.*,
                crs.course_id, 
                crs.course_code, 
                crs.name as course_name 
            FROM student s
            INNER JOIN gender g ON s.gender_id = g.gender_id
            INNER JOIN address a ON s.address_id = a.address_id
            INNER JOIN city c ON c.city_id = a.city_id
            LEFT JOIN student_course sc on sc.student_id = s.student_id
            LEFT JOIN course crs on sc.course_id = crs.course_id
            WHERE (s.first_name LIKE ? OR s.last_name LIKE ?)
        """;
        
        Object[] args = {
            "%" + filter + "%",
            "%" + filter + "%"
        };
        return jdbcTemplate.query(sql, args, new StudentMapper());
    }
    
    public List<StudentByCourse> getStudentsByCourse(Integer courseId) {
        log.info("Searching students for course id " + courseId);
        String sql = """
            SELECT 
                sc.registration_date, 
                sc.registration_id, 
                s.student_id, 
                s.first_name, 
                s.last_name, 
                s.email, 
                c.course_id, 
                c.course_code, 
                c.name as course_name 
            FROM 
                    student_course sc, student s, course c 
            WHERE sc.student_id = s.student_id 
            AND   sc.course_id = c.course_id
            AND   c.course_id = ?
        """;
        
        Object[] args = {
            courseId
        };
        return jdbcTemplate.query(sql, args, new StudentsByCourseMapper());
    }
    
    public Student getStudentById(Integer studentId) {
        log.info("Fetching student by id " + studentId);
        String sql = "SELECT\n" +
        "    s.student_id,\n" +
        "    s.first_name,\n" +
        "    s.last_name,\n" +
        "    s.email,\n" +
        "    s.ppsn,\n" +
        "    g.*,\n" +
        "    a.*,\n" +
        "    c.*,\n" +
        "    crs.course_id, \n" +
        "    crs.course_code, \n" +
        "    crs.name as course_name \n" +
        "FROM student s\n" +
        "INNER JOIN gender g ON s.gender_id = g.gender_id\n" +
        "INNER JOIN address a ON s.address_id = a.address_id\n" +
        "INNER JOIN city c ON c.city_id = a.city_id\n" +
        "LEFT JOIN student_course sc on sc.student_id = s.student_id\n" +
        "LEFT JOIN course crs on sc.course_id = crs.course_id\n" +
        "WHERE s.student_id = ?";
        
        Object[] args = {
            studentId
        };
        return jdbcTemplate.queryForObject(sql, args, new StudentMapper());
    }
    
    public void insertStudent(Student student) {
        log.info("Inserting student" + student);
        
        String sql = """
            INSERT INTO student (address_id, gender_id, first_name, last_name, email, ppsn)
            VALUES (?, ?, ?, ?, ?, ?)
        """;
        
        Object[] args = {
            student.getAddress().getAddressId(),
            student.getGenderId(),
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getPpsn()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void deleteStudent(Integer studentId) {
        log.info("Deleting student with id " + studentId);
        
        String sql = """
            DELETE FROM student
            WHERE student_id = ?
        """;
        
        Object[] args = {
            studentId
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void updateStudent(Student student) {
        log.info("Updating student " + student);
        
        String sql = """
            UPDATE student
            SET
            	gender_id = ?,
            	first_name = ?,
            	last_name = ?,
            	email = ?,
            	ppsn = ?
            WHERE student_id = ?
        """;
        
        Object[] args = {
            student.getGenderId(),
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getPpsn(),
            student.getStudentId()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void registerStudentInCourse(Student student, Integer courseId) {
        log.info("Registering student id" + student.getStudentId() + " on course id courseId " + courseId);
        String sql = "INSERT INTO student_course (student_id, course_id, registration_id, registration_date, payment_ok) " +
                        "VALUES (?, ?, ?, ?, ?)";
        
        int currentYearLastTwoDigits = Calendar.getInstance().get(Calendar.YEAR) % 100;
        Integer registrationId = Integer.parseInt(""+currentYearLastTwoDigits+courseId+student.getStudentId());
        Date date = Date.valueOf(LocalDate.now());
        
        Object[] args = {
            student.getStudentId(),
            courseId,
            registrationId,
            date,
            NOT_PAID
        };
        
        
        jdbcTemplate.update(sql, args);
        
    }

    public void unregisterStudentFromCourse(StudentByCourse student) {
        String sql = "DELETE FROM student_course WHERE student_id = ? AND course_id = ?";
        
        Object[] args = {
            student.getStudentId(),
            student.getCourseId()
        };
        
        jdbcTemplate.update(sql, args);
        
    }
  
    
}
