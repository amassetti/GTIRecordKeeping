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
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.event.PdfDocumentEvent;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import edu.gti.asd.ariel.recordkeeping.dao.AddressDao;
import edu.gti.asd.ariel.recordkeeping.model.Address;
import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import edu.gti.asd.ariel.recordkeeping.model.Subject;
import edu.gti.asd.ariel.recordkeeping.model.SubjectStudentGrade;
import static edu.gti.asd.ariel.recordkeeping.service.GenerateReportServiceCSVImpl.log;


import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author ariel
 */
@Service("pdfReportService")
public class GenerateReportServicePDFImpl implements GenerateReportService {
    
    static Logger log = Logger.getLogger(GenerateReportServicePDFImpl.class.getName());
    
    // TODO: relative path
    private static final String IMAGE_PATH = "/home/ariel/NetBeansProjects/GTIRecordKeeping/src/main/resources/images/gti-logo.png";
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private GradeService gradeService;

    
    @Override
    public void listOfStudentsByCourse(String fullFilename, Integer courseId) {
        log.info("Generating List of Students pdf report for courseId " + courseId);
        
        List<StudentByCourse> students = studentService.getStudentsByCourse(courseId);
        Course course = courseService.getCourseById(courseId);
        
        try {
            Document document = createPdfDocument(fullFilename, false);
            
            addGtiLogo(document);
            
            addTitle(document, "Course: " + course.getName() + " (" + course.getCode() + ")");
            
            addTitle(document, "List of Students");
            
            for (StudentByCourse student : students) {
                document.add(new Paragraph(student.getLastName() + ", " + student.getLastName() + "\t\t\t Email: " + student.getEmail()));
            }            

            // Close the document
            document.close();

            System.out.println("PDF created successfully: " + fullFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void gradesByCourseAndSubject(String fullFilename, Integer courseId, Integer subjectId) {
        List<SubjectStudentGrade> studentsGrades = gradeService.getGradesForStudentsInCourse(courseId, subjectId);
        Course course = courseService.getCourseById(courseId);
        Subject subject = subjectService.getSubjectById(subjectId);
        
        try {
            Document document = createPdfDocument(fullFilename, true);
            
            addGtiLogo(document);
            
            addTitle(document, "Course: " + course.getName() + " (" + course.getCode() + ")");
            addTitle(document, "Subject: " + subject.getSubjectName() + " (" + subject.getSubjectCode() + ")" );
            
            addTitle(document, "List of Grades for Course " + course.getCode() + " and Subject " + subject.getSubjectCode());

            
            for (SubjectStudentGrade sg : studentsGrades) {
                document.add(
                        new Paragraph(
                                normalizeLength(sg.getStudentLastName() + ", " + sg.getStudentFirstName(), 30) 
                                + "\t\t Assignment 1: " + sg.getAssesment1()
                                + ", Assignment 2: " + sg.getAssesment2()
                                + ", Assignment 3: " + sg.getAssesment3()
                                + ", Final Exam: " + sg.getFinalExam()
                        )
                );
            }
            

            // Close the document
            document.close();

            System.out.println("PDF created successfully: " + fullFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void studentReport(String fullFilename, Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        Course course = student.getCourse();
        
        try {
            Document document = createPdfDocument(fullFilename, true);
            
            addGtiLogo(document);
            
            if (course != null) {
                addTitle(document, "Course: " + course.getName() + " (" + course.getCode() + ")");
            } else {
                addTitle(document, "Course: STUDENT NOT ENROLLED YET");
            }
            
            addTitle(document, "Report for Student  " + student.getLastName()+ ", " + student.getFirstName());
            
            document.add(new Paragraph("First Name: " + student.getFirstName() + "\t\t\tLast Name: " + student.getLastName()));
            document.add(new Paragraph("Email: " + student.getEmail() + "\t\t\tPPSN: " + student.getPpsn()));
            document.add(new Paragraph("Gender: " + student.getGender()+ "\t\t\tStudent ID: " + student.getStudentId()));
            
            Address address = student.getAddress();
            
            if (address != null) {
                addTitle(document, "Address:");
                document.add(new Paragraph("Line 1: " + address.getAddressLine1()));
                document.add(new Paragraph("Line 2: " + address.getAddressLine2()));
                document.add(new Paragraph("City: " + address.getCity()));
                document.add(new Paragraph("Eir Code: " + address.getEirCode()));
            }

            // Close the document
            document.close();

            System.out.println("PDF created successfully: " + fullFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String normalizeLength(String input, int length) {
        String spaces = "                                                                                    ";
        String result = "";
        if (input.length() < length) {
            // complete with spaces at the end
            result = input + spaces.substring(0, (length - input.length()) -1);
        } else if (input.length() > length) {
            // truncate
             result = input.substring(0, length-1);
        } else {
            result = input;
        }
        return result;
    }
    
    private Document createPdfDocument(String filePath, boolean landscape) throws IOException {
            // Step 1: Create a PdfWriter instance
            PdfWriter writer = new PdfWriter(new File(filePath));

            // Step 2: Create a PdfDocument instance
            PdfDocument pdf = new PdfDocument(writer);
            
            if (landscape) {
                // Set page size to landscape (A4 rotated)
                pdf.setDefaultPageSize(PageSize.A4.rotate());
            }
            
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
