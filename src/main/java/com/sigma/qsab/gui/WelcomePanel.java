package com.sigma.qsab.gui;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;

public class WelcomePanel extends ImagePanel {       
    
    public WelcomePanel(Image img, GUIStrings gs, ActionListener al) {
        super(img);
        setBackground(GUIFields.BGCOLOR);
        setLayout(null);
        add(ComponentMaker.makeStandardButton(gs.getString(GUIStrings.LOGIN),
                new Point(600,400), al, "welcome_login"));                
        add(ComponentMaker.makeStandardButton(gs.getString(GUIStrings.REGISTER),
                new Point(600,450), al, "welcome_register"));                        
    }
    
}
