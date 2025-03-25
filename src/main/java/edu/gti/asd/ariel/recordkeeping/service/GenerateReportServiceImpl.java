/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

import java.io.IOException;
import org.springframework.stereotype.Service;
/**
 *
 * @author ariel
 */
@Service
public class GenerateReportServiceImpl implements GenerateReportService {

    @Override
    public void gradesByCourseAndSubject(Integer courseId, Integer subjectId) {
        String filePath = "/tmp/output.pdf"; // Change this path if needed

        try {
            // Step 1: Create a PdfWriter instance
            PdfWriter writer = new PdfWriter(new File(filePath));

            // Step 2: Create a PdfDocument instance
            PdfDocument pdf = new PdfDocument(writer);

            // Step 3: Create a Document instance
            Document document = new Document(pdf);

            // Step 4: Add content to the document
            document.add(new Paragraph("Hello, this is a generated PDF using iText!"));

            // Step 5: Close the document
            document.close();

            System.out.println("PDF created successfully: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
