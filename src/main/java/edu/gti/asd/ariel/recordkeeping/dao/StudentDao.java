/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.StudentMapper;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class StudentDao {
    static Logger log = Logger.getLogger(StudentDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Student> getStudents() {
        log.info("Getting all students from DB");
        String sql = "    SELECT\n" +
                        "	s.student_id,\n" +
                        "    s.first_name,\n" +
                        "    s.last_name,\n" +
                        "    s.email,\n" +
                        "    s.ppsn,\n" +
                        "    g.*,\n" +
                        "    a.*,\n" +
                        "    c.*\n" +
                        "FROM student s,\n" +
                        "     gender g,\n" +
                        "     address a,\n" +
                        "     city c\n" +
                        "where \n" +
                        "    s.gender_id = g.gender_id and\n" +
                        "    s.address_id = a.address_id and\n" +
                        "    a.city_id=c.city_id";
        
        
        
        return jdbcTemplate.query(sql, new StudentMapper());
    }
    
    
    public List<Student> searchStudents(String filter) {
        log.info("Searching students with filter" + filter);
        String sql = "    SELECT\n" +
                        "    s.student_id,\n" +
                        "    s.first_name,\n" +
                        "    s.last_name,\n" +
                        "    s.email,\n" +
                        "    s.ppsn,\n" +
                        "    g.*,\n" +
                        "    a.*,\n" +
                        "    c.*\n" +
                        "FROM student s, \n" +
                        "     gender g, \n" +
                        "     address a, \n" +
                        "     city c \n" +
                        "where \n" +
                        "    s.gender_id = g.gender_id and \n" +
                        "    s.address_id = a.address_id and \n" +
                        "    a.city_id=c.city_id and \n" +
                        "   (s.first_name LIKE ? OR s.last_name LIKE ?)";
        
        Object[] args = {
            "%" + filter + "%",
            "%" + filter + "%"
        };
        return jdbcTemplate.query(sql, args, new StudentMapper());
    }
    
    public void insertStudent(Student student) {
        log.info("Inserting student" + student);
        String sql = "INSERT INTO student (address_id, gender_id, first_name, last_name, email, ppsn) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
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
        String sql = "DELETE FROM student " +
                     " WHERE student_id = ?";
        
        Object[] args = {
            studentId
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void updateStudent(Student student) {
        log.info("Updating student " + student);
        String sql = "UPDATE student\n" +
                        "SET\n" +
                        "	gender_id = ?,\n" +
                        "	first_name = ?,\n" +
                        "	last_name = ?,\n" +
                        "	email = ?,\n" +
                        "	ppsn = ?\n" +
                        "WHERE student_id = ?";
        
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
    
    
}
