/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.GradeDao;
import edu.gti.asd.ariel.recordkeeping.model.Grade;
import edu.gti.asd.ariel.recordkeeping.model.SubjectStudentGrade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class GradeServiceImpl implements GradeService {
    
    @Autowired
    private GradeDao gradeDao;

    @Override
    public Grade getGradesForStudent(Integer studentId, Integer subjectId) {
        return gradeDao.getGradesForStudent(studentId, subjectId);
    }

    @Override
    public List<SubjectStudentGrade> getGradesForStudentsInCourse(Integer courseId, Integer subjectId) {
        return gradeDao.getGradesForStudentsInCourse(courseId, subjectId);
    }

    @Override
    public void registerGradeForStudent(Integer studentId, Integer subjectId, Grade grade) {
        gradeDao.registerGradeForStudent(studentId, subjectId, grade);
    }

    @Override
    public void registerGradesForSubject(List<SubjectStudentGrade> subjectStudentGrades) {
        
        for (SubjectStudentGrade subjectStudentGrade : subjectStudentGrades) {
            Integer studentId = subjectStudentGrade.getStudentId();
            Integer subjectId = subjectStudentGrade.getSubjectId();
            
            Grade grade = new Grade(
                    subjectStudentGrade.getAssesment1(),
                    subjectStudentGrade.getAssesment2(),
                    subjectStudentGrade.getAssesment3(),
                    subjectStudentGrade.getFinalExam()
            );
            
            gradeDao.registerGradeForStudent(studentId, subjectId, grade);
        }
        
    }
    
}
