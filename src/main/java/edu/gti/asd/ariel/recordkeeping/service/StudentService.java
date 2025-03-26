/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface StudentService {
    List<Student> getStudents();
    List<Student> searchStudents(String filter);
    Student getStudentById(Integer studentId);
    
    void insertStudent(Student student) throws IllegalAccessException;
    void deleteStudent(Student student);
    void updateStudent(Student student);
    
    List<StudentByCourse> getStudentsByCourse(Integer courseId);
    void registerStudentsInCourse(List<Student> ableStudents, Integer courseId);
    void unregisterStudentsFromCourse(List<StudentByCourse> studentsToUnregister);
}
