package com.sigma.qsab.gui;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterComponent<F extends JTextField> {

    private JLabel titleLabel, textLabel;
    private F field;
    private boolean mandatory;
    private String title;

    private RegisterComponent(String title, boolean mandatory,
            int xpos, int ypos, F field) {
        this.title = title;
        titleLabel = new JLabel();
        textLabel = new JLabel();
        this.field = field;
        setMandatory(mandatory);
        titleLabel.setBackground(GUIFields.BGCOLOR);
        field.setBackground(GUIFields.BGCOLOR);
        titleLabel.setBounds(xpos, ypos, GUIFields.W_LABEL, GUIFields.H_LABEL);
        field.setBounds(xpos + GUIFields.W_LABEL + GUIFields.HORIZONTALGAP,
                ypos, GUIFields.W_TEXTFIELD, GUIFields.H_TEXTFIELD);
        textLabel.setBounds(field.getBounds());
        textLabel.setVisible(false);
        titleLabel.setName("title_" + title);
        textLabel.setName("text_" + title);
        field.setName("field_" + title);
    }

    public static RegisterComponent<JTextField> newTextFieldComponent(
            String text, boolean mandatory, int xpos, int ypos) {
        return new RegisterComponent<JTextField>(text, mandatory, xpos, ypos,
                new JTextField());
    }

    public static RegisterComponent<JPasswordField> newPasswordFieldComponent(
            String text, boolean mandatory, int xpos, int ypos) {
        return new RegisterComponent<JPasswordField>(text, mandatory, xpos, ypos,
                new JPasswordField());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getText() {
        return field.getText();
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public final void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
        titleLabel.setText((mandatory ? "*" : "") + title + ":");
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
            setFieldError(false);
        }
    }

    public boolean isEditable() {
        return field.isVisible();
    }

    public void updateTextLabelText() {
        textLabel.setText(field.getText());
    }

    public void clearField() {
        field.setText("");
    }
    
    public void setFieldError(boolean isError) {
        titleLabel.setForeground(isError ? GUIFields.ERRORCOLOR : GUIFields.FGCOLOR);
    }
}
