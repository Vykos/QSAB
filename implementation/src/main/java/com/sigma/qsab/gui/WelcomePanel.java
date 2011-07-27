package com.sigma.qsab.gui;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;

public class WelcomePanel extends ImagePanel {       
    
    public WelcomePanel(Image img, GUIStrings strings, ActionListener al) {
        super(img);
        setBackground(GUIFields.BGCOLOR);
        setLayout(null);
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.LOGIN),
                new Point(600,400), al, "welcome_login"));                
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.REGISTER),
                new Point(600,450), al, "welcome_register"));                        
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.CHOOSEGLITCHES),
                new Point(600,600), al, "welcome_superadmin"));   
    }
    
}
