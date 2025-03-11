/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Subject implements IComboElement {
    Integer subjectId;
    String subjectCode;
    String subjectName;
    String subjectDescription;
    Integer nfqLevel;

    public Subject() {
    }

    public Subject(Integer subjectId, String subjectCode, String subjectName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }
    
    public Integer getNfqLevel() {
        return nfqLevel;
    }

    public void setNfqLevel(Integer nfqLevel) {
        this.nfqLevel = nfqLevel;
    }
    
    public String getSubjectCodeAndName() {
        return getSubjectCode() + " - " + getSubjectName();
    }

    @Override
    public String toString() {
        return getSubjectCodeAndName();
    }

    @Override
    public Integer getComboElementId() {
        return getSubjectId();
    }

    @Override
    public String getComboElementDescription() {
        return getSubjectCodeAndName();
    }
    
    
}
