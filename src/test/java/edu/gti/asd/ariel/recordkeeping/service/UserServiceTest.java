/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.UserDao;
import edu.gti.asd.ariel.recordkeeping.model.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyString;
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
public class UserServiceTest {
    
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetUserByUsername_UserExists() {
        // Arrange
        String userName = "pepeLui";
        Integer userId = 1;
        User mockUser = new User();
        mockUser.setUserId(userId);
        mockUser.setUsername(userName);
        when(userDao.getUserByUsername(userName)).thenReturn(Optional.of(mockUser));

        // Act
        User user = userService.getUserByUsername(userName).get();
        
        // Assert
        assertEquals(mockUser.getUsername(), user.getUsername());
    }
    
    @Test
    void testGetUserByUsername_UserDoesNotExists() {
        // Arrange
        when(userDao.getUserByUsername(anyString())).thenReturn(Optional.empty());

        // Act
        User user = userService.getUserByUsername("username").orElse(null);
        
        // Assert
        assertEquals(user, null);
        
        verify(userDao, times(1)).getUserByUsername(anyString());
    }
    
    @Test
    void testRegisterUser_Ok() {
        // Arrange
        String userName = "pepeLui";
        Integer userId = 1;
        User mockUser = new User();
        mockUser.setUserId(userId);
        mockUser.setUsername(userName);
        
        userService.registerUser(mockUser);
        verify(userDao, times(1)).registerUser(mockUser);
    }
    
    @Test
    void testRegisterUser_AlreadyExistingUser() {
        // Arrange
        String userName = "pepeLui";
        Integer userId = 1;
        
        User mockUser = new User();
        mockUser.setUserId(userId);
        mockUser.setUsername(userName);
        
        Optional<User> mockUserOpt = Optional.of(mockUser);
        
        when(userDao.getUserByUsername(userName)).thenReturn(mockUserOpt);
        
        // Act
        
        // Assert that an exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.registerUser(mockUser);
        });
        
        // Verify the exception message
        assert(exception.getMessage().contains("already registered"));
        
    }
    
    @Test
    void testGetUsers() {
        // Arrange
        List<User> mockUsers = Arrays.asList(
                new User(1, "pepelui"),
                new User(2, "ariel"),
                new User(3, "johnSmith")
        );
        when(userDao.getUsers()).thenReturn(mockUsers);
        
        // Act
        List<User> users = userService.getUsers();
        
        // Assert
        assertEquals(users, mockUsers);
        
        verify(userDao, times(1)).getUsers();
    }
    
    
}
