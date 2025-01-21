/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class CourseType implements IComboElement {
    private Integer courseTypeId;
    private String description;

    public CourseType() {
    }

    public CourseType(Integer courseTypeId, String description) {
        this.courseTypeId = courseTypeId;
        this.description = description;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    @Override
    public Integer getComboElementId() {
        return getCourseTypeId();
    }

    @Override
    public String getComboElementDescription() {
        return getDescription();
    }
    
}
