/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.GenderDao;
import edu.gti.asd.ariel.recordkeeping.model.Gender;
import java.util.List;

/**
 *
 * @author ariel
 */
public class GenderServiceImpl implements GenderService {
    
    private GenderDao genderDao;

    public void setGenderDao(GenderDao genderDao) {
        this.genderDao = genderDao;
    }

    @Override
    public List<Gender> getGenders() {
        return genderDao.getGenders();
    }
    
}
