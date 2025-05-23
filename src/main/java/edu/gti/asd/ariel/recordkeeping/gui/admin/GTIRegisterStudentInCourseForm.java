/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.gui.admin;

import edu.gti.asd.ariel.recordkeeping.model.Course;
import edu.gti.asd.ariel.recordkeeping.model.IComboElement;
import edu.gti.asd.ariel.recordkeeping.model.Student;
import edu.gti.asd.ariel.recordkeeping.model.StudentByCourse;
import edu.gti.asd.ariel.recordkeeping.service.CourseService;
import edu.gti.asd.ariel.recordkeeping.service.StudentService;
import edu.gti.asd.ariel.recordkeeping.utils.ContextManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariel
 */
public class GTIRegisterStudentInCourseForm extends javax.swing.JFrame {
    private ContextManager contextManager;
    
    private CourseService courseService;
    private StudentService studentService;
    
    private List<Student> students;
    private List<StudentByCourse> studentsByCourse;
    private List<Course> courses;
    
    private Course selectedCourse;

    /**
     * Creates new form GTIRegisterStudentInCourseForm
     */
    public GTIRegisterStudentInCourseForm(ContextManager contextManager) {
        initComponents();
        this.contextManager = contextManager;
        initBeans();
        fetchDataFromDB();
        populateStudentsTable();
        populateCoursesCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudentsByCourse = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStudents = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFilterStudent = new javax.swing.JTextField();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jButtonSearchStudent = new javax.swing.JButton();
        jButtonRegisterStudent = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSelectedCourse = new javax.swing.JTextField();
        jButtonClearFilter = new javax.swing.JButton();
        jButtonUnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Student in Course");

        jTableStudentsByCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Email", "Enrolled Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableStudentsByCourse);

        jTableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Course"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableStudents);

        jLabel1.setText("Select Course:");

        jLabel2.setText("Filter Student:");

        jComboBoxCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCourseItemStateChanged(evt);
            }
        });

        jButtonSearchStudent.setText("Search");
        jButtonSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchStudentActionPerformed(evt);
            }
        });

        jButtonRegisterStudent.setText(">>>");
        jButtonRegisterStudent.setToolTipText("Register");
        jButtonRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterStudentActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Register Student in Course");

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel4.setText("Selected Course:");

        jTextFieldSelectedCourse.setEditable(false);

        jButtonClearFilter.setText("Clear");
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

        jButtonUnRegister.setText("<<<");
        jButtonUnRegister.setToolTipText("Unregister");
        jButtonUnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21)
                                .addComponent(jTextFieldFilterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSearchStudent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonClearFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(478, 478, 478))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonRegisterStudent)
                                    .addComponent(jButtonUnRegister))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxCourse, 0, 567, Short.MAX_VALUE)
                                            .addComponent(jTextFieldSelectedCourse)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldSelectedCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldFilterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearchStudent)
                            .addComponent(jButtonClearFilter))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jButtonRegisterStudent)
                                .addGap(44, 44, 44)
                                .addComponent(jButtonUnRegister)))))
                .addGap(27, 27, 27)
                .addComponent(jButtonExit)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jComboBoxCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCourseItemStateChanged
        Course course = (Course) evt.getItem();
        if (!selectedCourse.getCourseId().equals(course.getCourseId())) {
            selectedCourse = course;
            
            if (course.getCourseId().equals(-1)) {
                jTextFieldSelectedCourse.setText("");
            } else {
                jTextFieldSelectedCourse.setText(course.getName());
                searchStudentsByCourse();
            }
            
        }
        
    }//GEN-LAST:event_jComboBoxCourseItemStateChanged

    private void searchStudentsByCourse() {
        // search students by course
        studentsByCourse = studentService.getStudentsByCourse(selectedCourse.getCourseId());
        populateStudentsByCourseTable();
    }
    
    private void jButtonSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchStudentActionPerformed
        searchStudents();
    }//GEN-LAST:event_jButtonSearchStudentActionPerformed

    private void searchStudents() {
        String filter = jTextFieldFilterStudent.getText();
        students = studentService.searchStudents(filter);
        populateStudentsTable();
    }
    
    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed
        jTextFieldFilterStudent.setText("");
        students = studentService.getStudents();
        populateStudentsTable();
    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    private void jButtonRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterStudentActionPerformed
        int[] selectedRows = jTableStudents.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Must select one or more students to enroll");
            return;
        }
        
        Integer courseId = selectedCourse.getCourseId();
        if (courseId.equals(-1)) {
            JOptionPane.showMessageDialog(this, "Must select a course to enroll the students into.");
        } else {
        
            // check selected students are not registerd in another course
            List<Student> unableStudents = new ArrayList();
            List<Student> ableStudents = new ArrayList();
            for (int i : selectedRows) {
                Student student = students.get(i);
                if (!student.hasCourse() ) {
                    ableStudents.add(student);
                } else {
                    unableStudents.add(student);
                }
            }
            
            studentService.registerStudentsInCourse(ableStudents, courseId);
            
            if (unableStudents.size() > 0) {
                JOptionPane.showMessageDialog(this, "Some selected students are already enrolled in a course. \nThose won't be registered.");
            }
            
            searchStudents();
            searchStudentsByCourse();
        
        }
    }//GEN-LAST:event_jButtonRegisterStudentActionPerformed

    private void jButtonUnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnRegisterActionPerformed
        int[] selectedRows = jTableStudentsByCourse.getSelectedRows();
        
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Must select one or more students to un register");
            return;
        }
        
        List<StudentByCourse> studentsToUnregister = new ArrayList();
        for (int i : selectedRows) {
            StudentByCourse student = studentsByCourse.get(i);
            studentsToUnregister.add(student);
        }
        
        studentService.unregisterStudentsFromCourse(studentsToUnregister);
        
        searchStudents();
        searchStudentsByCourse();
        
    }//GEN-LAST:event_jButtonUnRegisterActionPerformed

    private void initBeans() {
        this.studentService = contextManager.getBean(StudentService.class);
        this.courseService = contextManager.getBean(CourseService.class);
    }

    private void fetchDataFromDB() {
        this.students = studentService.getStudents();
        this.courses = courseService.getAllCourses();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRegisterStudent;
    private javax.swing.JButton jButtonSearchStudent;
    private javax.swing.JButton jButtonUnRegister;
    private javax.swing.JComboBox<IComboElement> jComboBoxCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableStudents;
    private javax.swing.JTable jTableStudentsByCourse;
    private javax.swing.JTextField jTextFieldFilterStudent;
    private javax.swing.JTextField jTextFieldSelectedCourse;
    // End of variables declaration//GEN-END:variables

    private void populateStudentsTable() {
        DefaultTableModel tableModel = (DefaultTableModel)jTableStudents.getModel();
        
        // Clean table
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        
        for (Student student : students) {
            Vector row = new Vector();
            row.add(student.getStudentId());
            row.add(student.getFirstName());
            row.add(student.getLastName());
            
            Course course = student.getCourse();
            if (course != null) {
                row.add(course.getCode());
            } else {
                row.add("");
            }
            
            tableModel.addRow(row);
        }
        
    }

    private void populateCoursesCombo() {
        selectedCourse = new Course(-1, "Select course...");
        jComboBoxCourse.addItem(selectedCourse);
        for (Course course : courses) {
            jComboBoxCourse.addItem(course);
        }
    }

    private void populateStudentsByCourseTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jTableStudentsByCourse.getModel();
        
        // Clean table
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        
        for (StudentByCourse studentByCourse : studentsByCourse) {
            Vector row = new Vector();
            row.add(studentByCourse.getStudentId());
            row.add(studentByCourse.getFirstName());
            row.add(studentByCourse.getLastName());
            row.add(studentByCourse.getEmail());
            row.add(studentByCourse.getRegistrationDate());
            tableModel.addRow(row);
        }
        
    }
}
