/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Subject;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface SubjectService {
    List<Subject> getAllSubjects();
    List<Subject> searchSubjects(String filter);
    Subject getSubjectById(Integer subjectId);
    
    void insertSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Integer subjectId);
    
    List<Subject> getSubjectsByCourse(Integer courseId);
    void registerSubjectsInCourse(List<Subject> subjectsToAdd, Integer courseId);
    void unregisterSubjectsFromCourse(List<Subject> subjectsToUnregister, Integer courseId);

    public List<Subject> getSubjectsByCourseAndTeacher(Integer courseId, Integer teacherId);
    
}
