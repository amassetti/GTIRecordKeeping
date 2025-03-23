/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.utils;

import edu.gti.asd.ariel.recordkeeping.model.IComboElement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ariel
 */
public class FieldsUtils {

    public static void validateComboWithIdSelected(javax.swing.JFrame parentFrame, JComboBox jComboBox, String name) {
        IComboElement comboElement = (IComboElement) jComboBox.getSelectedItem();
        
        Integer id = comboElement.getComboElementId();
        if (id.equals(Integer.valueOf(-1))) {
            JOptionPane.showMessageDialog(parentFrame, "Must select a valid " + name);
            return;
        }
    }
    
    public static void validateTextFieldHasValue(JFrame parentFrame, JTextField jTextField, String name) {
        String text = jTextField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a value for " + name);
            return;
        }
    }
    
    public static String getValueFromTextField(JTextField jTextField) {
        return jTextField.getText().trim();
    }
    
    public static String getMandatoryValueFromTextField(JFrame parentFrame, JTextField jTextField, String name) {
        String text = jTextField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a value for " + name);
            jTextField.requestFocus();
        }
        return text;
    }
    
    public static Double getMandatoryDoubleValueFromTextField(JFrame parentFrame, JTextField jTextField, String name) {
        String text = jTextField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a value for " + name);
            jTextField.requestFocus();
        }

        Double value = null;
        try {
            value = Double.valueOf(text);
        } catch (NumberFormatException nfEx) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a valid decimal value for " + name);
            jTextField.requestFocus();
        }
        
        return value;
    }
    
    public static String getMandatoryValueFromTextArea(JFrame parentFrame, JTextArea jTextArea, String name) {
        String text = jTextArea.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a value for " + name);
            jTextArea.requestFocus();
        }
        return text;
    }
    
    
    public static Integer getMandatoryIdFromCombo(JFrame parentFrame, JComboBox<IComboElement> jComboBox, String name) {
        IComboElement selection = (IComboElement)jComboBox.getSelectedItem();
        Integer id = selection.getComboElementId();
        if (id.equals(-1)) {
            JOptionPane.showMessageDialog(parentFrame, "Please select a valid option for " + name);
            jComboBox.requestFocus();
        }
        return id;
    }
    
    public static void allowOnlyDigitsAndDecimalPoint(java.awt.event.KeyEvent evt) {
        char character = evt.getKeyChar();
        if ( ! (Character.isDigit(character) || character == '.' ) ) {
            evt.consume();
        }
    }
    
}
