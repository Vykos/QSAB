package com.sigma.qsab.gui;

import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
    
    private final static int v_gap = 100;
    private final static int h_gap = 50;
    private final static int x = GUIFields.W_APP/2 - (GUIFields.W_LABEL + v_gap)/2;
    private final static int y = GUIFields.H_APP/2 - (GUIFields.H_LABEL + h_gap)/2;
    
    JTextField socialIDField;
    JPasswordField passwordField;       
 
    public LoginPanel(GUIStrings strings, ActionListener al) {        
        setBackground(GUIFields.BGCOLOR);
        setLayout(null);
        add(ComponentMaker.makeLabel(strings.getString(GUIStrings.SOCIALID), new Point(x,y)));
        add(ComponentMaker.makeLabel(strings.getString(GUIStrings.PASSWORD), new Point(x,y+h_gap)));
        socialIDField = ComponentMaker.makeTextField("", new Point(x+v_gap,y), 
                "field_" + strings.getString(GUIStrings.SOCIALID)); 
        passwordField = ComponentMaker.makePasswordField("", new Point(x+v_gap,y+h_gap), 
                "field_" + strings.getString(GUIStrings.PASSWORD));
        add(socialIDField);
        add(passwordField);
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.LOGIN),
                new Point(774, 688), al, "login_next"));
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.PREVIOUS),
                new Point(64, 688), al, "login_previous"));        
    }
    
    public String getSocialID() {
        return socialIDField.getText();
    }
    
    public String getPassword() {
        return new String(passwordField.getPassword());
    }        
}
