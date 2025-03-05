/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.SubjectDao;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.util.List;

/**
 *
 * @author ariel
 */
public class SubjectServiceImpl implements SubjectService {
    
    private SubjectDao subjectDao;

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
    

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public List<Subject> searchSubjects(String filter) {
        return subjectDao.searchSubjects(filter);
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
    
}
