/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.RoleDao;
import edu.gti.asd.ariel.recordkeeping.model.Role;
import java.util.List;

/**
 *
 * @author ariel
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
    
}
