/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CityDao;
import edu.gti.asd.ariel.recordkeeping.exceptions.RecordAlreadyExistsException;
import edu.gti.asd.ariel.recordkeeping.model.City;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityDao cityDao;

    
    @Override
    public List<City> getCities() {
        return cityDao.getCities();
    }

    @Override
    public List<City> searchByName(String filter) {
        return cityDao.searchByName(filter);
    }
    
    @Override
    public Optional<City> findByCityNameAndCounty(String cityName, String county) {
        List<City> cities = cityDao.findByCityNameAndCounty(cityName, county);
        Optional cityOpt = Optional.ofNullable((cities != null && cities.size() > 0) ? cities.get(0) : null);
        return cityOpt;
    }

    @Override
    public void insertCity(City city) {
        Optional<City> cityOpt = findByCityNameAndCounty(city.getCityName(), city.getCounty());
        if (cityOpt.isPresent()) {
            throw new RecordAlreadyExistsException("City " + city.getCityName() + " with county " + city.getCounty() + " already exists.");
        }
        cityDao.insertCity(city);
    }

    @Override
    public void updateCity(City city) {
        cityDao.updateCity(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityDao.deleteCity(id);
    }
    
}
