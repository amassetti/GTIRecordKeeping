/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.SubjectDao;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    
    @Autowired
    private SubjectDao subjectDao;


    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public List<Subject> searchSubjects(String filter) {
        return subjectDao.searchSubjects(filter);
    }
    
    @Override
    public Subject getSubjectById(Integer subjectId) {
        return subjectDao.getSubjectById(subjectId);
    }

    @Override
    public void insertSubject(Subject subject) {
        subjectDao.insertSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        subjectDao.deleteSubject(subjectId);
    }

    @Override
    public List<Subject> getSubjectsByCourse(Integer courseId) {
        return subjectDao.getSubjectsByCourse(courseId);
    }

    @Override
    public void registerSubjectsInCourse(List<Subject> subjectsToAdd, Integer courseId) {
        for (Subject subject : subjectsToAdd) {
            subjectDao.registerSubjectInCourse(subject, courseId);
        }        
    }

    @Override
    public void unregisterSubjectsFromCourse(List<Subject> subjectsToUnregister, Integer courseId) {
        for (Subject subject : subjectsToUnregister) {
            subjectDao.unregisterSubjectFromCourse(subject, courseId);
        }        
    }

    @Override
    public List<Subject> getSubjectsByCourseAndTeacher(Integer courseId, Integer teacherId) {
        return subjectDao.getSubjectsByCourseAndTeacher(courseId, teacherId);
    }
    
}
