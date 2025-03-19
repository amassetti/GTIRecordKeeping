/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

import java.sql.Date;

/**
 *
 * @author ariel
 */
public class Grade {
    
    private Integer studentId;
    private Integer subjectId;
    private Date lastUpdated;
    private String lastUpdatedBy;
    private Double assesment1;
    private Double assesment2;
    private Double assesment3;
    private Double finalExam;
    private Double overall;

    public Grade() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Double getAssesment1() {
        return assesment1;
    }

    public void setAssesment1(Double assesment1) {
        this.assesment1 = assesment1;
    }

    public Double getAssesment2() {
        return assesment2;
    }

    public void setAssesment2(Double assesment2) {
        this.assesment2 = assesment2;
    }

    public Double getAssesment3() {
        return assesment3;
    }

    public void setAssesment3(Double assesment3) {
        this.assesment3 = assesment3;
    }

    public Double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Double finalExam) {
        this.finalExam = finalExam;
    }

    public Double getOverall() {
        return overall;
    }

    public void setOverall(Double overall) {
        this.overall = overall;
    }

    @Override
    public String toString() {
        return "Grade{" + "studentId=" + studentId + ", subjectId=" + subjectId + ", lastUpdated=" + lastUpdated + ", lastUpdatedBy=" + lastUpdatedBy + ", assesment1=" + assesment1 + ", assesment2=" + assesment2 + ", assesment3=" + assesment3 + ", finalExam=" + finalExam + ", overall=" + overall + '}';
    }    
    
    
}
