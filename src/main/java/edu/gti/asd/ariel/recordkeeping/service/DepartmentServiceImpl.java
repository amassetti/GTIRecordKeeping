/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.DepartmentDao;
import edu.gti.asd.ariel.recordkeeping.model.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public List<Department> searchByName(String departmentName) {
        return departmentDao.searchByName(departmentName);
    }
    
    @Override
    public void insertDepartment(Department department) {
        departmentDao.insertDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }
    
}
