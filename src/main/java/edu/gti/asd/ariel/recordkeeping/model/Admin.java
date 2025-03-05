/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Admin extends Person implements IComboElement {
    private Integer adminId;

    public Admin() {
    }

    public Admin(Integer adminId, String firstName, String lastName) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName();
    }

    @Override
    public Integer getComboElementId() {
        return getAdminId();
    }

    @Override
    public String getComboElementDescription() {
        return getLastName() + ", " + getFirstName();
    }
    
    
}
