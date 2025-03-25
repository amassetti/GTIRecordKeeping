/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.io.image.PngImageData;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.event.PdfDocumentEvent;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;


import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author ariel
 */
@Service
public class GenerateReportServiceImpl implements GenerateReportService {
    
    // TODO: relative path
    private static final String IMAGE_PATH = "/home/ariel/NetBeansProjects/GTIRecordKeeping/src/main/resources/images/gti-logo.png";
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private SubjectService subjectService;

    
    @Override
    public void listOfStudentsByCourse(Integer courseId) {
        String filePath = "/tmp/list_students_course_" + courseId + ".pdf"; // Change this path if needed

        List<StudentByCourse> students = studentService.getStudentsByCourse(courseId);
        Course course = courseService.getCourseById(1);
        
        try {
            
            Document document = createPdfDocument(filePath);
            
            addGtiLogo(document);
            
            
            addTitle(document, "Course: " + course.getName() + " (" + course.getCode() + ")");
            
            addTitle(document, "List of Students");
            
            
            for (StudentByCourse student : students) {
                document.add(new Paragraph(student.getLastName() + ", " + student.getLastName() + "\t\t\t Email: " + student.getEmail()));
            }
            

            // Close the document
            document.close();

            System.out.println("PDF created successfully: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void gradesByCourseAndSubject(Integer courseId, Integer subjectId) {
        String filePath = "/tmp/output.pdf"; // Change this path if needed

        List<Student> students = studentService.getStudents();
        Course course = courseService.getCourseById(1);
        
        try {
            
            Document document = createPdfDocument(filePath);
            
            addGtiLogo(document);
            
            
            addTitle(document, "Course: " + course.getName());
            
            addTitle(document, "List of Students");
            
            

            
            for (Student student : students) {
                document.add(new Paragraph(student.getLastName() + ", " + student.getLastName()));
            }
            

            // Close the document
            document.close();

            System.out.println("PDF created successfully: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Document createPdfDocument(String filePath) throws IOException {
            // Step 1: Create a PdfWriter instance
            PdfWriter writer = new PdfWriter(new File(filePath));

            // Step 2: Create a PdfDocument instance
            PdfDocument pdf = new PdfDocument(writer);
            
            Document document = new Document(pdf);
            
            return document;
    }
    
    private void addGtiLogo(Document document) throws MalformedURLException {
        // Load image
        ImageData imageData = ImageDataFactory.create(IMAGE_PATH);
        Image image = new Image(imageData);
        Style style = new Style();
        style.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        image.addStyle(style);
        document.add(image);
    }
    
    private void addTitle(Document document, String title) throws IOException {
        // Load a bold font
        PdfFont boldFont = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD);

        // Create styled text (bold & underlined)
        Text boldUnderlinedText = new Text(title)
                .setFont(boldFont)
                .setUnderline();

        // Add text to paragraph and document
        Paragraph paragraph = new Paragraph(boldUnderlinedText);
        document.add(paragraph);
    }
    
}
