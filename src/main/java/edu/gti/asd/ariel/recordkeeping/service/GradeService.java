/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Grade;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface GradeService {
    Grade getGradesForStudent(Integer studentId, Integer subjectId);
    List<Grade> getGradesForStudentsInCourse(Integer courseId);
    
    void registerGradeForStudent(Integer studentId, Integer subjectId, Grade grade);
    void registerGradesForSubject(List<Grade> grades);
    
}
