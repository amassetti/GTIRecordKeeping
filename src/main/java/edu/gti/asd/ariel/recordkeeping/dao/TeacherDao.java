/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.TeacherMapper;
import edu.gti.asd.ariel.recordkeeping.mappers.TeacherSubjectMapper;
import edu.gti.asd.ariel.recordkeeping.model.Teacher;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class TeacherDao {
    static Logger log = Logger.getLogger(TeacherDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Teacher> getTeachers() {
        log.info("Fetching all teachers from db");
        
        String sql = "    SELECT\n" +
                        "    t.teacher_id,\n" +
                        "    t.first_name,\n" +
                        "    t.last_name,\n" +
                        "    t.email,\n" +
                        "    t.ppsn,\n" +
                        "    g.*,\n" +
                        "    a.*,\n" +
                        "    c.*\n" +
                        "FROM teacher t,\n" +
                        "     gender g,\n" +
                        "     address a,\n" +
                        "     city c\n" +
                        "where \n" +
                        "    t.gender_id = g.gender_id and\n" +
                        "    t.address_id = a.address_id and\n" +
                        "    a.city_id=c.city_id";
        
        return jdbcTemplate.query(sql, new TeacherMapper());
    }
    
    public void insertTeacher(Teacher teacher) {
        log.info("Inserting teacher into db: " + teacher);
        String sql = "INSERT INTO teacher (address_id, gender_id, first_name, last_name, email, ppsn) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        Object[] args = {
            teacher.getAddress().getAddressId(),
            teacher.getGenderId(),
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getEmail(),
            teacher.getPpsn()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void deleteTeacher(Integer teacherId) {
        log.info("Deleting teacher with id " + teacherId);
        String sql = "DELETE FROM teacher " +
                     " WHERE teacher_id = ?";
        
        Object[] args = {
            teacherId
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void updateTeacher(Teacher teacher) {
        log.info("Updating teacher " + teacher);
        String sql = "UPDATE teacher\n" +
                        "SET\n" +
                        "	gender_id = ?,\n" +
                        "	first_name = ?,\n" +
                        "	last_name = ?,\n" +
                        "	email = ?,\n" +
                        "	ppsn = ?\n" +
                        "WHERE teacher_id = ?";
        
        Object[] args = {
            teacher.getGenderId(),
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getEmail(),
            teacher.getPpsn(),
            teacher.getTeacherId()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public List<Teacher> searchTeachersBySubject(Integer subjectId) {
        log.info("Searching teachers by subject id: " + subjectId);
        
        String sql = "SELECT t.teacher_id, t.first_name, t.last_name, t.email FROM teacher t, teacher_subject ts where t.teacher_id = ts.teacher_id AND ts.subject_id = ?";
        Object[] args = {
            subjectId
        };
        
        return jdbcTemplate.query(sql, args, new TeacherSubjectMapper());
    }

    public void registerTeacherInSubject(Integer teacherId, Integer subjectId) {
        log.info("Registering teacher id: " + teacherId + " into subject id: " + subjectId);
        
        String sql = "INSERT INTO teacher_subject (teacher_id, subject_id, registration_date ) \n" +
                     "VALUES (?,?,?)";
        
        Date date = Date.valueOf(LocalDate.now());
        
        Object[] args = {
            teacherId,
            subjectId,
            date
        };
        
        jdbcTemplate.update(sql, args);
    }
    
    
}
