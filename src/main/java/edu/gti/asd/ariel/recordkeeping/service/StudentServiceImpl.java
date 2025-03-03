/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.dao.StudentDao;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import java.util.List;

/**
 *
 * @author ariel
 */
public class StudentServiceImpl implements StudentService {
    
    private StudentDao studentDao;
    private AddressDao addressDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }
    
    @Override
    public List<Student> searchStudents(String filter) {
        return studentDao.searchStudents(filter);
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

    
    
}
