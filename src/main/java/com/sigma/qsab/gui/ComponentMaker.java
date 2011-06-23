/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ext.jonas.frogvall
 */
public class ComponentMaker {
    
    public static JButton makeStandardButton(String text, Point position,
            ActionListener listener, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(GUIFields.BGCOLOR);        
        button.setBounds(position.x, position.y, GUIFields.BUTTONWIDTH, 
                                           GUIFields.BUTTONHEIGHT);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);                
        return button;
    }
}
