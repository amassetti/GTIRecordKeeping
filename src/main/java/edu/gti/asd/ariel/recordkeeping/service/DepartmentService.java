/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Department;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface DepartmentService {
    
    List<Department> getDepartments();
    List<Department> searchByName(String departmentName);
    void insertDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Integer departmentId);
    
    
}
