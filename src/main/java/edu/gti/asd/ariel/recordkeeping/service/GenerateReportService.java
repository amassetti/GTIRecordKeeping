/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

/**
 *
 * @author ariel
 */
public interface GenerateReportService {
    public void listOfStudentsByCourse(String fullFilename, Integer courseId);
    public void gradesByCourseAndSubject(String fullFilename, Integer courseId, Integer subjectId);
    public void studentReport(String fullFilename, Integer studentId);
}
