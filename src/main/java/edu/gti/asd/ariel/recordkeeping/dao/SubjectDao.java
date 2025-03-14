/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.SubjectMapper;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.sql.Date;
import java.time.LocalDate;
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
public class SubjectDao {
    static Logger log = Logger.getLogger(SubjectDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Subject> getAllSubjects() {
        log.info("Fetching all subjects from db...");
        String sql = "SELECT * FROM subject";        
        return jdbcTemplate.query(sql, new SubjectMapper());
    }

    public List<Subject> searchSubjects(String filter) {
        log.info("Fetching all subjects from db with filter: " + filter);
        String sql = "SELECT * FROM subject WHERE subject_name LIKE ?";
        
        Object[] args = {
            "%" + filter + "%"
        };
        
        return jdbcTemplate.query(sql, args, new SubjectMapper());
    }

    public void insertSubject(Subject subject) {
        log.info("Inserting subject into db: " + subject);
        String sql = "INSERT INTO subject (subject_code, subject_name, subject_description, nfq_level) " +
                     "VALUES (?, ?, ?, ?)";
        
        Object[] args = {
            subject.getSubjectCode(),
            subject.getSubjectName(),
            subject.getSubjectDescription(),
            subject.getNfqLevel()
        };
        
        jdbcTemplate.update(sql, args);

    }

    public void updateSubject(Subject subject) {
        log.info("Updating subject into db: " + subject);
        String sql = "UPDATE subject SET " +
                "subject_code = ?, " +
                "subject_name = ?, " +
                "subject_description = ?, " +
                "nfq_level = ? " +
                " WHERE subject_id = ?";
        
        Object[] args = {
            subject.getSubjectCode(),
            subject.getSubjectName(),
            subject.getSubjectDescription(),
            subject.getNfqLevel(),
            subject.getSubjectId()
        };
        
        jdbcTemplate.update(sql, args);

    }

    public void deleteSubject(Integer subjectId) {
        log.info("Deleting subject from db: " + subjectId);
        String sql = "DELETE FROM subject WHERE subject_id = ?";
        Object[] args = {
            subjectId
        };
            
        jdbcTemplate.update(sql, args);

    }

    public List<Subject> getSubjectsByCourse(Integer courseId) {
        log.info("Fetching subjects by course id: " + courseId);
        String sql = "SELECT * \n" +
                        "FROM subject_course sc, subject s \n" +
                        "WHERE  s.subject_id = sc.subject_id \n" +
                        "AND sc.course_id = ?";
        Object[] args = {
            courseId
        };
        
        return jdbcTemplate.query(sql, args, new SubjectMapper());
        
    }

    public void registerSubjectInCourse(Subject subject, Integer courseId) {
        log.info("Registering subject " + subject + " in course id: " + courseId);
        String sql = "INSERT INTO subject_course (subject_id, course_id, registration_date) " +
                "VALUES (?,?,?)";
        
        Date date = Date.valueOf(LocalDate.now());
        
        Object[] args = {
            subject.getSubjectId(),
            courseId,
            date
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void unregisterSubjectFromCourse(Subject subject, Integer courseId) {
        log.info("Unregistering subject " + subject + " from course id: " + courseId);
        String sql = "DELETE FROM subject_course WHERE subject_id = ? and course_id = ?";
                
        Object[] args = {
            subject.getSubjectId(),
            courseId
        };
        
        jdbcTemplate.update(sql, args);
    }

    public List<Subject> getSubjectsByCourseAndTeacher(Integer courseId, Integer teacherId) {
        log.info("Fetching subjects by course id: " + courseId + " and teacherId: " + teacherId);
        String sql = "SELECT * FROM subject s \n" +
                    "INNER JOIN subject_course sc ON s.subject_id = sc.subject_id  \n" +
                    "INNER JOIN teacher_subject ts ON s.subject_id = ts.subject_id \n" +
                    "WHERE  sc.course_id = ? \n" +
                    "AND ts.teacher_id = ?";
        Object[] args = {
            courseId,
            teacherId
        };
        
        return jdbcTemplate.query(sql, args, new SubjectMapper());
    }
    
}
