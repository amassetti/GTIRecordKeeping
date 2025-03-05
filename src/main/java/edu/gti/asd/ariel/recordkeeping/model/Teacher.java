/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Teacher extends Person{
    private Integer teacherId;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String email) {
        this.teacherId = teacherId;
        this.email = email;
    }
    
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", genderId=" + genderId + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", ppsn=" + ppsn + ", address=" + address + '}';
    }
    
    
    
    
}
