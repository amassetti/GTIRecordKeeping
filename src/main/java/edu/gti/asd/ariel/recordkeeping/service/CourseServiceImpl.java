/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseDao;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.util.List;

/**
 *
 * @author ariel
 */
public class CourseServiceImpl implements CourseService {
    
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
    
    @Override
    public List<Course> searchByCourseName(String courseName) {
        return courseDao.searchByCourseName(courseName);
    }

    @Override
    public void insertCourse(Course course) {
        courseDao.insertCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        courseDao.deleteCourse(courseId);
    }
    
}
