/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.utils;

import edu.gti.asd.ariel.recordkeeping.GTIRecordKeepingConfig;
import edu.gti.asd.ariel.recordkeeping.service.GenerateReportService;
import edu.gti.asd.ariel.recordkeeping.service.GenerateReportServiceCSVImpl;
import edu.gti.asd.ariel.recordkeeping.service.GenerateReportServicePDFImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ariel
 */
public class GenerateReportMain {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GTIRecordKeepingConfig.class);
        
        ContextManager contextManager = new ContextManager(context);
        
        GenerateReportService pdfReportService = contextManager.getBean(GenerateReportServicePDFImpl.class);
        pdfReportService.listOfStudentsByCourse(1);
        
        pdfReportService.gradesByCourseAndSubject(1, 3);
        
        pdfReportService.studentReport(1);
        
        GenerateReportService csvReportService = contextManager.getBean(GenerateReportServiceCSVImpl.class);
        csvReportService.listOfStudentsByCourse(1);
        
    }
    
}
