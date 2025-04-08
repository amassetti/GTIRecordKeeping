/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseDao;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author ariel
 */
@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    
    @Mock
    private CourseDao courseDao;
    
    @InjectMocks
    CourseServiceImpl courseService;
    
    @Test
    public void testGetCourseById() {
        
        // Arrange
        Integer courseId = Integer.valueOf(1);
        String name = "Course1";
        
        Course mockCourse = new Course(courseId, name);
        
        when(courseDao.getCourseById(courseId)).thenReturn(mockCourse);
        
        // Act
        Course course = courseService.getCourseById(courseId);
        
        // Assert
        assertEquals(course.getName(), mockCourse.getName());
        verify(courseDao, times(1)).getCourseById(courseId);
        
    }
    
    @Test
    public void testGetAllCourses() {
        // Arrange
        Integer courseId = Integer.valueOf(1);
        String name = "Course1";
        
        List<Course> mockCourses = Arrays.asList(
                new Course(1, "Course 1"),
                new Course(2, "Course 2"),
                new Course(3, "Course 3")
        );
        
        
        when(courseDao.getAllCourses()).thenReturn(mockCourses);
        
        // Act
        List<Course> courses = courseService.getAllCourses();
        
        // Assert
        assertEquals(courses, mockCourses);
        verify(courseDao, times(1)).getAllCourses();
    }
    
}
