/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Gender implements IComboElement {
    private Integer genderId;
    private String genderName;

    public Gender() {
    }

    public Gender(Integer genderId, String genderName) {
        this.genderId = genderId;
        this.genderName = genderName;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    @Override
    public String toString() {
        return genderName;
    }

    @Override
    public Integer getComboElementId() {
        return getGenderId();
    }

    @Override
    public String getComboElementDescription() {
        return getGenderName();
    }
    
}
