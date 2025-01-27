/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.model.Address;

/**
 *
 * @author ariel
 */
public class AddressServiceImpl implements AddressService {
    
    private AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    
    @Override
    public Integer insertAddress(Address address) {
        return addressDao.insertAddress(address);
    }
    
}
