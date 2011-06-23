/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ext.jonas.frogvall
 */
public class RegisterComponent <F extends JTextField> {
    
    private JLabel titleLabel, textLabel;
    private F field;
    private boolean mandatory;
    private String  text;

    private RegisterComponent(String text, boolean mandatory, 
            int xpos, int ypos, F field) {
        this.text = text;        
        titleLabel = new JLabel();        
        textLabel = new JLabel();        
        this.field = field;      
        setMandatory(mandatory);
        titleLabel.setBackground(GUIFields.BGCOLOR);
        field.setBackground(GUIFields.BGCOLOR);        
        titleLabel.setBounds(xpos, ypos, GUIFields.LABELWIDTH, GUIFields.LABELHEIGHT);        
        field.setBounds(xpos+GUIFields.LABELWIDTH+GUIFields.HORIZONTALGAP,
                ypos, GUIFields.TEXTFIELDWIDTH, GUIFields.TEXTFIELDHEIGHT);
        textLabel.setBounds(field.getBounds());
        textLabel.setVisible(false);        
    }
    
    public static RegisterComponent<JTextField> newTextFieldComponent(String text, 
            boolean mandatory, int xpos, int ypos) {
        return new RegisterComponent<JTextField>(text, mandatory, xpos, ypos, 
                new JTextField());
    }
    
    public static RegisterComponent<JPasswordField> newPasswordFieldComponent(String text,
            boolean mandatory, int xpos, int ypos) {
        return new RegisterComponent<JPasswordField>(text, mandatory, xpos, ypos,
                new JPasswordField());
    }
    
    public boolean isMandatory() {
        return mandatory;
    }
    
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
        titleLabel.setText((mandatory ? "*" : "") + text + ":");
    }
    
    public JLabel getTitleLabel() {
        return titleLabel;
    }
    
    public JLabel getTextLabel() {
        return textLabel;
    }        
    
    public F getField() {
        return field;
    }
    
    public void setEditable(boolean editable) {
        if (editable) {
            textLabel.setVisible(false);
            field.setVisible(true);
        } else {
            textLabel.setVisible(true);
            field.setVisible(false);
        }
    }
    
    public boolean isEditable() {
        return field.isVisible();
    }
    
    public void updateTextLabelText() {
        textLabel.setText(field.getText());
        System.out.println(text + ": " + textLabel.getText());
    }
    
    public void clearField() {
        field.setText("");
    }
}
