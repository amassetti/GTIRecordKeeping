/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

/**
 *
 * @author ariel
 */
@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    private AddressDao addressDao;
    
    @InjectMocks
    private AddressServiceImpl addressService;
    
    @Test
    public void testInsertAddress() {
        
        // arrange
        Address mockAddress = new Address();
        
        when(addressDao.insertAddress(mockAddress)).thenReturn(1);
        
        // act
        Integer addressId = addressService.insertAddress(mockAddress);
        
        // assert
        Assertions.assertEquals(addressId, 1);
        
    }
    
}
