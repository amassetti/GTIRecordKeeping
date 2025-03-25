/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseDao;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseDao courseDao;


    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
   
    @Override
    public List<Course> getCoursesByTeacherId(Integer teacherId) {
        return courseDao.getCoursesByTeacherId(teacherId);
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

    @Override
    public Integer registerStudent(Course course, Student student) {
        return courseDao.registerStudent(course, student);
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }

    
}
