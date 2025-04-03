/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.dao;

import edu.gti.asd.ariel.recordkeeping.mappers.CityMapper;
import edu.gti.asd.ariel.recordkeeping.model.City;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ariel
 */
@Repository
public class CityDao {
    static Logger log = Logger.getLogger(CityDao.class.getName());
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<City> getCities() {
        String sql = "SELECT * FROM city ORDER BY county, city_name";
        return jdbcTemplate.query(sql, new CityMapper());
    }

    public List<City> searchByName(String filter) {
        log.info("Filtering cities with filter: " + filter);
        String sql = "SELECT * FROM city WHERE city_name LIKE ? ORDER BY county, city_name";
        Object[] args = {
            "%" + filter + "%"
        };
        return jdbcTemplate.query(sql, args, new CityMapper());
    }

    public void insertCity(City city) {
        log.info("Inserting city " + city);
        String sql = "INSERT INTO city (city_name, county) values (?, ?)";
        
        Object[] args = {
            city.getCityName(),
            city.getCounty()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void updateCity(City city) {
        log.info("Updating city " + city);
        String sql = "UPDATE city SET city_name = ?, county = ? WHERE city_id = ?";
        
        Object[] args = {
            city.getCityName(),
            city.getCounty(),
            city.getCityId()
        };
        
        jdbcTemplate.update(sql, args);
    }

    public void deleteCity(Integer id) {
        log.info("Deleting city with id " + id);
        String sql = "DELETE FROM city where city_id = ? ORDER BY county, city_name";
        
        Object[] args = {
            id
        };
        
        jdbcTemplate.update(sql, args);
    }

    public List<City> findByCityNameAndCounty(String cityName, String county) {
        log.info("Filtering cities with name: " + cityName + " and county " + county);
        String sql = "SELECT * FROM city WHERE city_name = ? AND county = ? ORDER BY county, city_name";
        Object[] args = {
            cityName,
            county
        };
        return jdbcTemplate.query(sql, args, new CityMapper());
    }
    
}
