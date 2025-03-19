/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Grade;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class GradeMapper implements RowMapper {
    
    private final static String STUDENT_ID = "student_id";
    private final static String SUBJECT_ID = "subject_id";
    private final static String ASSIGNMENT_1 = "assesment_1";
    private final static String ASSIGNMENT_2 = "assesment_2";
    private final static String ASSIGNMENT_3 = "assesment_3";
    private final static String FINAL_EXAM = "final_exam";
    private final static String OVERALL = "overall";
    

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Grade grade = new Grade();
        
        if (rs.findColumn(STUDENT_ID) >= 0) {
            grade.setStudentId(rs.getInt(STUDENT_ID));
        }
        
        if (rs.findColumn(SUBJECT_ID) >= 0) {
            grade.setSubjectId(rs.getInt(SUBJECT_ID));
        }
        
        if (rs.findColumn(ASSIGNMENT_1) >= 0) {
            grade.setAssesment1(rs.getDouble(ASSIGNMENT_1));
        }
        
        if (rs.findColumn(ASSIGNMENT_2) >= 0) {
            grade.setAssesment2(rs.getDouble(ASSIGNMENT_2));
        }
        
        if (rs.findColumn(ASSIGNMENT_3) >= 0) {
            grade.setAssesment3(rs.getDouble(ASSIGNMENT_3));
        }
        
        if (rs.findColumn(FINAL_EXAM) >= 0) {
            grade.setFinalExam(rs.getDouble(FINAL_EXAM));
        }
        
        if (rs.findColumn(OVERALL) >= 0) {
            grade.setOverall(rs.getDouble(OVERALL));
        }
        
        return grade;
    }
    
}
