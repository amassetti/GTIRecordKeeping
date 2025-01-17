/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface CourseService {
    List<Course> getAllCourses();
    void insertCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Integer courseId);
    
    
}
