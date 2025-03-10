/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Teacher extends Person implements IComboElement {
    private Integer teacherId;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String email) {
        this.teacherId = teacherId;
        this.email = email;
    }
    
    public Teacher(Integer teacherId, String firstName, String lastName) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName();
    }

    @Override
    public Integer getComboElementId() {
        return getTeacherId();
    }

    @Override
    public String getComboElementDescription() {
        return getLastName() + ", " + getFirstName();
    }
    
    
    
    
}
