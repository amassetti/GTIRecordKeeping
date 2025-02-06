/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import edu.gti.asd.ariel.recordkeeping.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ariel
 */
public interface UserService {
    Optional<User> getUserByUsername(String username);
    void registerUser(User user);

    public List<User> getUsers();
}
