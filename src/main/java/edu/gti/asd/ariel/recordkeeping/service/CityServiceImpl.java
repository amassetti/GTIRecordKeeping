/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CityDao;
import edu.gti.asd.ariel.recordkeeping.model.City;
import java.util.List;

/**
 *
 * @author ariel
 */
public class CityServiceImpl implements CityService {
    
    private CityDao cityDao;

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    
    @Override
    public List<City> getCities() {
        return cityDao.getCities();
    }
    
}
