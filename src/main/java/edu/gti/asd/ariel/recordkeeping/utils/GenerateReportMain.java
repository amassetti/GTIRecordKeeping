/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.utils;

import edu.gti.asd.ariel.recordkeeping.GTIRecordKeepingConfig;
import edu.gti.asd.ariel.recordkeeping.service.GenerateReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ariel
 */
public class GenerateReportMain {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GTIRecordKeepingConfig.class);
        
        ContextManager contextManager = new ContextManager(context);
        
        GenerateReportService reportService = contextManager.getBean(GenerateReportService.class);
        
        reportService.listOfStudentsByCourse(1);
        
    }
    
}
