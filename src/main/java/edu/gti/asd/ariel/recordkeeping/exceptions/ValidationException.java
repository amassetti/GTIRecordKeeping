/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.exceptions;

/**
 *
 * @author ariel
 */
public class ValidationException extends GTIRecordKeepingException {
    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
    
}
