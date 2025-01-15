/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.DepartmentMapper;
import edu.gti.asd.ariel.recordkeeping.model.Department;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ariel
 */
public class DepartmentDao {
    
    static Logger log = Logger.getLogger(DepartmentDao.class.getName());
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Department> getDepartments() {
        log.info("Getting all departments from db...");
        String sql = "SELECT * FROM department";
        return jdbcTemplate.query(sql, new DepartmentMapper());
    }
    
    public void insertDepartment(Department department) {
        log.info("Inserting department " + department);
        String sql = "INSERT INTO department (name, description) values (?, ?)";
        
        Object[] args = {
            department.getName(),
            department.getDescription()
        };
        
        jdbcTemplate.update(sql, args);
    }
    
    
    public void updateDepartment(Department department) {
        log.info("Updating department " + department);
        String sql = "UPDATE department SET name = ?, description = ? WHERE department_id = ?";
        
        Object[] args = {
            department.getName(),
            department.getDescription(),
            department.getDepartmentId()
        };
        
        jdbcTemplate.update(sql, args);
    }
    
    public void deleteDepartment(Integer departmentId) {
        log.info("Deleting department " + departmentId);
        String sql = "DELETE FROM department WHERE department_id = ?";
        
        Object[] args = {
            departmentId
        };
        
        jdbcTemplate.update(sql, args);
        
    }
}
