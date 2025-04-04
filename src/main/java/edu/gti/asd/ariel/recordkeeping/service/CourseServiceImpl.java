/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseDao;
import edu.gti.asd.ariel.recordkeeping.exceptions.RecordAlreadyExistsException;
import edu.gti.asd.ariel.recordkeeping.exceptions.ValidationException;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import java.util.List;
import java.util.Optional;
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
    public Optional<Course> getCoursesByCode(String courseCode) {
        List<Course> courses = courseDao.getCoursesByCode(courseCode);
        
        Optional<Course> courseOpt = Optional.ofNullable(
                (courses != null && courses.size() > 0) ? courses.get(0) : null
        );
        return courseOpt;
    }
    
    @Override
    public List<Course> searchByCourseName(String courseName) {
        return courseDao.searchByCourseName(courseName);
    }

    @Override
    public void insertCourse(Course course) {
        if (course.getCode() == null || course.getCode().trim().isEmpty()) {
            throw new ValidationException("Course code is mandatory");
        }
        
        Optional<Course> courseOpt = getCoursesByCode(course.getCode());
        if (courseOpt.isPresent()) {
            throw new RecordAlreadyExistsException("Course code already exists " + course.getCode());
        }
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
    public Course getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }

    
}
