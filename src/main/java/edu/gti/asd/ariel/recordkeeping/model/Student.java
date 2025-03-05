/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Student extends Person{
    private Integer studentId;
    private Course course;
    
    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
        
    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", genderId=" + genderId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", ppsn=" + ppsn + ", address=" + address + '}';
    }
    
    public boolean hasCourse() {
        return (getCourse() != null && getCourse().getCourseId() != null);
    }
    
}
