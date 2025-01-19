/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseTypeDao;
import edu.gti.asd.ariel.recordkeeping.model.CourseType;
import java.util.List;

/**
 *
 * @author ariel
 */
public class CourseTypeServiceImpl implements CourseTypeService {
    
    private CourseTypeDao courseTypeDao;
    
    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CourseType> getCourseTypes() {
        return courseTypeDao.getCourseTypes();
    }
    
}
