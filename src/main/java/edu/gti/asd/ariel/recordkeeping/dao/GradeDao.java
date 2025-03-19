/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.model.Grade;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class GradeDao {
    static Logger log = Logger.getLogger(GradeDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Grade getGradesForStudent(Integer studentId) {
        String sql = "SELECT * FROM grade g \n" +
                    "INNER JOIN student st ON g.student_id = st.student_id \n" +
                    "INNER JOIN subject sj ON g.subject_id = sj.subject_id \n" +
                    "WHERE st.student_id = ?";
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Grade> getAllGradesForSubject(Integer subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void registerGradeForStudent(Integer studentId, Integer subjectId, Grade grade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void registerGradesForSubject(List<Grade> grades) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
