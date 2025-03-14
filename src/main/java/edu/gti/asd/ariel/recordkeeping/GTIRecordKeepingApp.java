/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping;

import edu.gti.asd.ariel.recordkeeping.gui.GTILoginForm;
import edu.gti.asd.ariel.recordkeeping.utils.ContextManager;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ariel
 */
public class GTIRecordKeepingApp {
    
    static Logger log = Logger.getLogger(GTIRecordKeepingApp.class.getName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GTIRecordKeepingConfig.class);
        
        ContextManager contextManager = new ContextManager(context);
        
        log.info("Starting GTIRecordKeeping App");
        
        log.info("Create and display the form");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GTILoginForm(contextManager).setVisible(true);
            }
        });
        
        log.info("Ending GTIRecordKeeping App");
    }
    
}
