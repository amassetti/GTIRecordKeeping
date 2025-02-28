/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.Teacher;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface TeacherService {
    List<Teacher> getTeachers();
    void insertTeacher(Teacher teacher) throws IllegalAccessException;
    void deleteTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
}
