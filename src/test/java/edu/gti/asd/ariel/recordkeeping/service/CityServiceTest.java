/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.CityDao;
import edu.gti.asd.ariel.recordkeeping.model.City;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
public class CityServiceTest {
    
    @Mock
    private CityDao cityDao;
    
    @InjectMocks
    private CityServiceImpl cityService;
    
    @Test
    public void testGetCities() {
        // Arrange
        List<City> mockCities = Arrays.asList(
                new City(1, "Galway"),
                new City(2, "Dublin"),
                new City(3, "Cork")
        );
        when(cityDao.getCities()).thenReturn(mockCities);
        
        // Act
        List<City> cities = cityService.getCities();
        
        // Assert
        Assertions.assertEquals(mockCities.size(), cities.size());
        Assertions.assertEquals(mockCities, cities);
        verify(cityDao, times(1)).getCities();
    }
    
    @Test
    public void testSearchCityByName() {
        // Arrange
        String filter = "anyFilter";
        List<City> mockCities = Arrays.asList(
                new City(1, "Galway"),
                new City(2, "Dublin"),
                new City(3, "Cork")
        );
        when(cityDao.searchByName(filter)).thenReturn(mockCities);
        
        // Act
        List<City> cities = cityService.searchByName(filter);
        
        // Assert
        Assertions.assertEquals(mockCities.size(), cities.size());
        Assertions.assertEquals(mockCities, cities);
        verify(cityDao, times(1)).searchByName(filter);
        
    }
    
    @Test
    public void testFindByCityNameAndCounty() {
        // Arrange
        String filterCityName = "Galway";
        String filterCounty = "Galway";
        
        List<City> mockCities = Arrays.asList(
                new City(1, "Galway", "Galway")
        );
        when(cityDao.findByCityNameAndCounty(filterCityName, filterCounty)).thenReturn(mockCities);
        
        // Act
        Optional<City> cityOpt = cityService.findByCityNameAndCounty(filterCityName, filterCounty);
        
        // Assert
        Assertions.assertEquals(cityOpt.get().getCityName(), filterCityName);
        Assertions.assertEquals(cityOpt.get().getCounty(), filterCounty);
        verify(cityDao, times(1)).findByCityNameAndCounty(filterCityName, filterCounty);
    }
    
    @Test
    public void testInsertCityOk() {
        // Arrange
        String cityName = "Mayo";
        String county = "Mayo";
        
        List<City> mockCities = Arrays.asList();
        when(cityDao.findByCityNameAndCounty(cityName, county)).thenReturn(mockCities);
        
        City city = new City(2, cityName, county);
        
        // Act
        cityService.insertCity(city);
        
        // Assert
        verify(cityDao, times(1)).insertCity(city);
    }
    
    @Test
    public void testInsertCityAlreadyExists() {
        // Arrange
        String cityName = "Mayo";
        String county = "Mayo";
        
        List<City> mockCities = Arrays.asList(
                new City(1, cityName, county)
        );
        when(cityDao.findByCityNameAndCounty(cityName, county)).thenReturn(mockCities);
        
        City city = new City(2, cityName, county);
        
        // Act
        // Assert that an exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            cityService.insertCity(city);
        });
        
        // Verify the exception message
        assertEquals(exception.getMessage(), "City " + city.getCityName() + " with county " + city.getCounty() + " already exists.");
        
        // Assert
        verify(cityDao, times(1)).findByCityNameAndCounty(cityName, county);
        verify(cityDao, times(0)).insertCity(city);
    }
    
    @Test
    public void testUpdateCityOk() {
        // Arrange
        String cityName = "Mayo";
        String county = "Mayo";
        
        City city = new City(2, cityName, county);
        
        // Act
        cityService.updateCity(city);
        
        // Assert
        verify(cityDao, times(1)).updateCity(city);
    }
    
    @Test
    public void testDeleteCityOk() {
        // Arrange
        Integer cityId = new Integer(1);
        
        // Act
        cityService.deleteCity(cityId);
        
        // Assert
        verify(cityDao, times(1)).deleteCity(cityId);
    }
    
}
