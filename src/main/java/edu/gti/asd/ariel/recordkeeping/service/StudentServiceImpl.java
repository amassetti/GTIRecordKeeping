/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.StudentDao;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import java.util.List;

/**
 *
 * @author ariel
 */
public class StudentServiceImpl implements StudentService {
    
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }
    
}
