/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AdminDao;
import edu.gti.asd.ariel.recordkeeping.model.Admin;
import java.util.List;

/**
 *
 * @author ariel
 */
public class AdminServiceImpl implements AdminService {
    
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    

    @Override
    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }
    
}
