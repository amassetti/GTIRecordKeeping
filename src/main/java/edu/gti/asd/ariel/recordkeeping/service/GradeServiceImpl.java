/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.GradeDao;
import edu.gti.asd.ariel.recordkeeping.model.Grade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ariel
 */
public class GradeServiceImpl implements GradeService {
    
    @Autowired
    private GradeDao gradeDao;

    @Override
    public Grade getGradesForStudent(Integer studentId) {
        return gradeDao.getGradesForStudent(studentId);
    }

    @Override
    public List<Grade> getAllGradesForSubject(Integer subjectId) {
        return gradeDao.getAllGradesForSubject(subjectId);
    }

    @Override
    public void registerGradeForStudent(Integer studentId, Integer subjectId, Grade grade) {
        gradeDao.registerGradeForStudent(studentId, subjectId, grade);
    }

    @Override
    public void registerGradesForSubject(List<Grade> grades) {
        gradeDao.registerGradesForSubject(grades);
    }
    
}
