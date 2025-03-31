/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.AdminDao;
import edu.gti.asd.ariel.recordkeeping.model.Admin;
import java.util.Arrays;
import java.util.List;
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
public class AdminServiceTest {
    @Mock
    private AdminDao adminDao;
    
    @InjectMocks
    private AdminServiceImpl adminService;
    
    @Test
    public void testInsertAddress() {
        
        // arrange
        List<Admin> mockListOfAdmins = Arrays.asList(
                new Admin(),
                new Admin(),
                new Admin()
        );
                
        Admin mockAdmin = new Admin();
        
        when(adminDao.getAllAdmins()).thenReturn(mockListOfAdmins);
        
        // act
        List<Admin> admins = adminService.getAllAdmins();
        
        // assert
        Assertions.assertEquals(admins.size(), mockListOfAdmins.size());
        
    }
    
}
