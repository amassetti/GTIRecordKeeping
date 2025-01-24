/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class City implements IComboElement {
    private Integer cityId;
    private String cityName;
    private String county;

    public City() {
    }

    public City(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return (getCounty() != null) ? getCityName() + " - " + getCounty() : getCityName();
    }

    @Override
    public Integer getComboElementId() {
        return getCityId();
    }

    @Override
    public String getComboElementDescription() {
        return getCityName() + " - " + getCounty();
    }
    
}
