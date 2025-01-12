/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping;

import edu.gti.asd.ariel.recordkeeping.gui.GTILoginForm;
import java.util.logging.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ariel
 */
public class GTIRecordKeepingApp {
    
    static Logger log = Logger.getLogger(GTIRecordKeepingApp.class.getName());
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        log.info("Starting GTIRecordKeeping App");
        
        log.info("Opening login form");
        GTILoginForm loginForm = new GTILoginForm(ctx);
        loginForm.setVisible(true);
        
        log.info("Ending GTIRecordKeeping App");
    }
    
}
