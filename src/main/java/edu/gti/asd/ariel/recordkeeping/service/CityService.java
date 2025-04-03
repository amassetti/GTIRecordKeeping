/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.City;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ariel
 */
public interface CityService {
    List<City> getCities();
    List<City> searchByName(String filter);
    Optional<City> findByCityNameAndCounty(String cityName, String county);
    void insertCity(City city);
    void updateCity(City city);
    void deleteCity(Integer id);
}
