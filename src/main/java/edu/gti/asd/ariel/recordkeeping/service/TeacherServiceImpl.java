/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.dao.TeacherDao;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Teacher;
import java.util.List;

/**
 *
 * @author ariel
 */
public class TeacherServiceImpl implements TeacherService {
    
    private TeacherDao teacherDao;
    private AddressDao addressDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherDao.getTeachers();
    }

    @Override
    public void insertTeacher(Teacher teacher) throws IllegalAccessException {
        
        if (teacher.getAddress() == null) throw new IllegalAccessException("No address has been registered for teacher");
        
        // Insert address
        Integer addressId = addressDao.insertAddress(teacher.getAddress());
        teacher.getAddress().setAddressId(addressId);
        
        // Insert teacher
        teacherDao.insertTeacher(teacher);
        
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher.getTeacherId());
        Address address = teacher.getAddress();
        addressDao.deleteAddress(address.getAddressId());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Address address = teacher.getAddress();
        addressDao.updateAddress(address);
        teacherDao.updateTeacher(teacher);
    }
    
    
    
}
