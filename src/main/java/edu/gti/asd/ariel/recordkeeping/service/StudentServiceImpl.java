/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.dao.StudentDao;
import edu.gti.asd.ariel.recordkeeping.exceptions.ValidationException;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private AddressDao addressDao;


    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }
    
    @Override
    public List<Student> searchStudents(String filter) {
        return studentDao.searchStudents(filter);
    }    
    
    @Override
    public List<StudentByCourse> getStudentsByCourse(Integer courseId) {
        return studentDao.getStudentsByCourse(courseId);
    }
    
    @Override
    public Student getStudentById(Integer studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void insertStudent(Student student) throws IllegalAccessException {
        
        if (student.getAddress() == null) throw new IllegalAccessException("No address has been registered for student");
        
        // Insert address
        Integer addressId = addressDao.insertAddress(student.getAddress());
        student.getAddress().setAddressId(addressId);
        
        // Insert student
        studentDao.insertStudent(student);
        
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student.getStudentId());
        Address address = student.getAddress();
        addressDao.deleteAddress(address.getAddressId());
    }

    @Override
    public void updateStudent(Student student) {
        Address address = student.getAddress();
        addressDao.updateAddress(address);
        studentDao.updateStudent(student);
    }

    @Override
    public void registerStudentsInCourse(List<Student> students, Integer courseId) {
        
        if (courseId == null) throw new ValidationException("Course id cannot be null");
        
        for (Student student : students) {
            studentDao.registerStudentInCourse(student, courseId);
        }
        
    }

    @Override
    public void unregisterStudentsFromCourse(List<StudentByCourse> studentsToUnregister) {
        
        for (StudentByCourse student : studentsToUnregister) {
            studentDao.unregisterStudentFromCourse(student);
        }
        
    }
   
    
}
