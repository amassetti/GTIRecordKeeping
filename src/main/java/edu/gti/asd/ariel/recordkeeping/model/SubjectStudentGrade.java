/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

import java.nio.file.Files;
import java.util.Vector;

/**
 *
 * @author ariel
 */
public class SubjectStudentGrade {
    Integer studentId;
    Integer subjectId;
    String studentFirstName;
    String studentLastName;
    Double assesment1;
    Double assesment2;
    Double assesment3;
    Double finalExam;
    
    String subjectCode;
    String subjectName;

    public SubjectStudentGrade() {
    }
    
    public SubjectStudentGrade(Vector data, Integer subjectId) {
        // data vector: [8, Adegboruwa, Olufemi, 1.2, 2.2, 3.3, 4.7]
        setStudentId((Integer)data.get(0));
        setSubjectId(subjectId);
        setStudentLastName((String)data.get(1));
        setAssesment1((Double)data.get(2));
        setAssesment2((Double)data.get(3));
        setAssesment3((Double)data.get(4));
        setFinalExam((Double)data.get(5));
        
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

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
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

    @Override
    public String toString() {
        return "StudentGrade{" + "studentId=" + studentId + ", subjectId=" + subjectId + ", studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + ", assesment1=" + assesment1 + ", assesment2=" + assesment2 + ", assesment3=" + assesment3 + ", finalExam=" + finalExam + '}';
    }
    
}
