/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service("csvReportService")
public class GenerateReportServiceCSVImpl implements GenerateReportService {
    
    static Logger log = Logger.getLogger(GenerateReportServiceCSVImpl.class.getName());
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private SubjectService subjectService;

    @Override
    public void listOfStudentsByCourse(Integer courseId) {
        log.info("Generating List of Students csv report for courseId " + courseId);
        List<StudentByCourse> students = studentService.getStudentsByCourse(courseId);
        Course course = courseService.getCourseById(courseId);
    }

    @Override
    public void gradesByCourseAndSubject(Integer courseId, Integer subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void studentReport(Integer studentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
