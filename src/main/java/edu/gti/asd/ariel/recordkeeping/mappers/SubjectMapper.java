/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.mappers;

import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class SubjectMapper implements RowMapper {

    // column names
    private final static String SUBJECT_ID = "subject_id";
    private final static String SUBJECT_CODE = "subject_code";
    private final static String SUBJECT_NAME = "subject_name";
    private final static String SUBJECT_DESCRIPTION = "subject_description";
    
    
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Subject subject = new Subject();

        if (rs.findColumn(SUBJECT_ID) >= 0) {
            subject.setSubjectId(rs.getInt(SUBJECT_ID));
        }
        
        if (rs.findColumn(SUBJECT_CODE) >= 0) {
            subject.setSubjectCode(rs.getString(SUBJECT_CODE));
        }
        
        if (rs.findColumn(SUBJECT_NAME) >= 0) {
            subject.setSubjectName(rs.getString(SUBJECT_NAME));
        }
        
        if (rs.findColumn(SUBJECT_DESCRIPTION) >= 0) {
            subject.setSubjectDescription(rs.getString(SUBJECT_DESCRIPTION));
        }
        
        

        return subject;
        
    }
    
}
