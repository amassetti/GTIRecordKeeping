/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.exceptions;

/**
 *
 * @author ariel
 */
public class UserAlreadyExistsException extends ValidationException {
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
    
}
