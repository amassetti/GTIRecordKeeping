/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.GradeMapper;
import edu.gti.asd.ariel.recordkeeping.model.Grade;
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
public class GradeDao {
    static Logger log = Logger.getLogger(GradeDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Grade getGradesForStudent(Integer studentId, Integer subjectId) {
        log.info("Getting grade for student id: " + studentId + " and subject id:" + subjectId);
        String sql = "SELECT * FROM grade g \n" +
                    "INNER JOIN student st ON g.student_id = st.student_id \n" +
                    "INNER JOIN subject sj ON g.subject_id = sj.subject_id \n" +
                    "WHERE st.student_id = ? AND sj.subject_id = ?";
        
        Object[] args = {
            studentId,
            subjectId
        };
        
        List<Grade> grades = jdbcTemplate.query(sql, args, new GradeMapper());
        
        Grade grade = (grades.isEmpty()) ? new Grade(0d,0d,0d,0d) : grades.get(0);
        
        return grade;
    }

    public List<Grade> getGradesForStudentsInCourse(Integer courseId) {
        String sql = "SELECT s.student_id, s.first_name, s.last_name, g.subject_id, g.assesment_1, g.assesment_2, g.assesment_3, g.final_exam\n" +
                    "FROM student s\n" +
                    "INNER JOIN student_course sc ON s.student_id = sc.student_id\n" +
                    "LEFT JOIN grade g ON g.student_id = s.student_id\n" +
                    "WHERE sc.course_id = ?;";


        Object[] args = {
            courseId
        };
        
        return jdbcTemplate.query(sql, args, new GradeMapper());
        
    }

    public void registerGradeForStudent(Integer studentId, Integer subjectId, Grade grade) {
        log.info("Calling SP  UpsertGrade for studentId: " + studentId + " - subjectId: "+ subjectId);
        String sql = "CALL UpsertGrade(?,?,?,?,?,?)";

        Object[] args = {
            studentId,
            subjectId,
            grade.getAssesment1(),
            grade.getAssesment2(),
            grade.getAssesment3(),
            grade.getFinalExam()
        };
        
        jdbcTemplate.update(sql, args);
        
    }

    public void registerGradesForSubject(List<Grade> grades) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
