/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CourseTypeDao;
import edu.gti.asd.ariel.recordkeeping.model.CourseType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    
    @Autowired
    private CourseTypeDao courseTypeDao;
    

    @Override
    public List<CourseType> getCourseTypes() {
        return courseTypeDao.getCourseTypes();
    }
    
}
