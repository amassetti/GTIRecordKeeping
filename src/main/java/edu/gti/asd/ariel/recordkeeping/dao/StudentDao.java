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
        String sql = "    SELECT\n" +
                        "	s.student_id,\n" +
                        "    s.first_name,\n" +
                        "    s.last_name,\n" +
                        "    s.email,\n" +
                        "    s.ppsn,\n" +
                        "    g.*,\n" +
                        "    a.*,\n" +
                        "    c.*\n" +
                        "FROM gti_record_keeping.student s,\n" +
                        "	 gti_record_keeping.gender g,\n" +
                        "     gti_record_keeping.address a,\n" +
                        "     gti_record_keeping.city c\n" +
                        "where \n" +
                        "	s.gender_id = g.gender_id and\n" +
                        "    s.address_id = a.address_id and\n" +
                        "    a.city_id=c.city_id";
        
        return jdbcTemplate.query(sql, new StudentMapper());
    }
    
    
}
