/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.SubjectStudentGrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import static edu.gti.asd.ariel.recordkeeping.utils.SqlHelper.hasColumn;

/**
 *
 * @author ariel
 */
public class SubjectStudentGradeMapper implements RowMapper {

    private static final String STUDENT_ID = "student_id";
    private static final String SUBJECT_ID = "subject_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String ASSESMENT_1 = "assesment_1";
    private static final String ASSESMENT_2 = "assesment_2";
    private static final String ASSESMENT_3 = "assesment_3";
    private static final String FINAL_EXAM = "final_exam";
    
    private static final String SUBJECT_CODE = "subject_code";
    private static final String SUBJECT_NAME = "subject_name";
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SubjectStudentGrade subjectStudentGrade = new SubjectStudentGrade();
        
        if (hasColumn(rs, STUDENT_ID)) {
            subjectStudentGrade.setStudentId(rs.getInt(STUDENT_ID));
        }
        
        if (hasColumn(rs, SUBJECT_ID)) {
            subjectStudentGrade.setSubjectId(rs.getInt(SUBJECT_ID));
        }
        
        if (hasColumn(rs, FIRST_NAME)) {
            subjectStudentGrade.setStudentFirstName(rs.getString(FIRST_NAME));
        }
        
        if (hasColumn(rs, LAST_NAME)) {
            subjectStudentGrade.setStudentLastName(rs.getString(LAST_NAME));
        }
        
        if (hasColumn(rs, ASSESMENT_1)) {
            subjectStudentGrade.setAssesment1(rs.getDouble(ASSESMENT_1));
        }
        
        if (hasColumn(rs, ASSESMENT_2)) {
            subjectStudentGrade.setAssesment2(rs.getDouble(ASSESMENT_2));
        }
        
        if (hasColumn(rs, ASSESMENT_3)) {
            subjectStudentGrade.setAssesment3(rs.getDouble(ASSESMENT_3));
        }
        
        if (hasColumn(rs, FINAL_EXAM)) {
            subjectStudentGrade.setFinalExam(rs.getDouble(FINAL_EXAM));
        }
        
        if (hasColumn(rs, SUBJECT_CODE)) {
            subjectStudentGrade.setSubjectCode(rs.getString(SUBJECT_CODE));
        }
        
        if (hasColumn(rs, SUBJECT_NAME)) {
            subjectStudentGrade.setSubjectName(rs.getString(SUBJECT_NAME));
        }
        
        return subjectStudentGrade;
    }
    
}
