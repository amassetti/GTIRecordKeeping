/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.GradeMapper;
import edu.gti.asd.ariel.recordkeeping.mappers.SubjectStudentGradeMapper;
import edu.gti.asd.ariel.recordkeeping.model.Grade;
import edu.gti.asd.ariel.recordkeeping.model.SubjectStudentGrade;
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

    public List<SubjectStudentGrade> getGradesForStudentsInCourse(Integer courseId, Integer subjectId) {
        log.info("Getting grades for students in course: " + courseId + " and subject id:" + subjectId);
        
        String sql = """
            SELECT   s.student_id, 
                     s.first_name, 
                     s.last_name, 
                     g.assesment_1, 
                     g.assesment_2, 
                     g.assesment_3, 
                     g.final_exam
            FROM student_course sc 
            INNER JOIN student s ON sc.student_id = s.student_id 
            LEFT JOIN grade g ON sc.student_id = g.student_id AND g.subject_id = ? 
            WHERE sc.course_id = ? ORDER BY s.last_name, s.first_name
        """;

        Object[] args = {
            subjectId,
            courseId
        };
        
        return jdbcTemplate.query(sql, args, new SubjectStudentGradeMapper());
        
    }
    
    
    public List<SubjectStudentGrade> getAllGradesForStudentsInCourse(Integer studentId) {
        log.info("Getting all grades for student id: " + studentId );
        
        String sql = "SELECT s.student_id, s.first_name, s.last_name, g.assesment_1, g.assesment_2, g.assesment_3, g.final_exam, sj.subject_code, sj.subject_name \n" +
                    "FROM grade g \n" +
                    "INNER JOIN student s ON g.student_id = s.student_id and s.student_id = ? \n" +
                    "INNER JOIN subject sj ON g.subject_id = sj.subject_id \n" +
                    "order by g.subject_id";

        Object[] args = {
            studentId
        };
        
        return jdbcTemplate.query(sql, args, new SubjectStudentGradeMapper());
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
    
}
