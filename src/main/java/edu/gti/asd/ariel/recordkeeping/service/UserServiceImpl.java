/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.dao.UserDao;
import edu.gti.asd.ariel.recordkeeping.exceptions.UserAlreadyExistsException;
import edu.gti.asd.ariel.recordkeeping.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    
    @Override
    public Optional<User> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public void registerUser(User user) {
        // Check username is not already registered
        Optional<User> userOptional = userDao.getUserByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("Username " + user.getUsername() + " already registered");
        }
        userDao.registerUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
    
    
}
