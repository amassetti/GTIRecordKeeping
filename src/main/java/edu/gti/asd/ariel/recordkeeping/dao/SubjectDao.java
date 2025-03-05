/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.SubjectMapper;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class SubjectDao {
    static Logger log = Logger.getLogger(SubjectDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
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
    
}
