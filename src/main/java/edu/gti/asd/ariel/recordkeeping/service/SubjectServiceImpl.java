/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.SubjectDao;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    static Logger log = Logger.getLogger(SubjectServiceImpl.class.getName());
    
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
            try {
                subjectDao.registerSubjectInCourse(subject, courseId);
            } catch (DuplicateKeyException dkEx) {
                log.warning("Duplicate record: " + dkEx.getMessage());
            }
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
