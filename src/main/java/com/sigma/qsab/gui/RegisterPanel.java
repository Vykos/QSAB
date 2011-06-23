/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ext.jonas.frogvall
 */
public class RegisterPanel extends JPanel {
    private ArrayList<RegisterComponent> componentList 
            = new ArrayList<RegisterComponent>();
    private final static int xpos = 300;
    private final static int ypos = 100;
    
    public RegisterPanel(GUIStrings gs, ActionListener al) {
        setLayout(null);    
        setBackground(GUIFields.BGCOLOR);
                
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.FIRSTNAME), true, 
                xpos, ypos));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.LASTNAME), true, 
                xpos, ypos+1*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.SOCIALID), true, 
                xpos, ypos+2*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.STREET), false, 
                xpos, ypos+3*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.ZIPCODE), false, 
                xpos, ypos+4*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.CITY), false, 
                xpos, ypos+5*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.PHONE), false, 
                xpos, ypos+6*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.CELLPHONE), true, 
                xpos, ypos+7*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newTextFieldComponent(
                gs.getString(GUIStrings.EMAIL), true, 
                xpos, ypos+8*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newPasswordFieldComponent(
                gs.getString(GUIStrings.PASSWORD), true, 
                xpos, ypos+9*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        componentList.add(RegisterComponent.newPasswordFieldComponent(
                gs.getString(GUIStrings.PASSWORDREPEAT), true, 
                xpos, ypos+10*(GUIFields.LABELHEIGHT+GUIFields.VERTICALGAP)));
        
        for (RegisterComponent component : componentList) {
            add(component.getTitleLabel());
            add(component.getTextLabel());
            add(component.getField());            
        }
                       
        add(ComponentMaker.makeStandardButton(gs.getString(GUIStrings.NEXT),
                new Point(774,688), al, "register_next"));        
        add(ComponentMaker.makeStandardButton(gs.getString(GUIStrings.PREVIOUS),
                new Point(64,688), al, "register_previous"));                        
    }   
    
    public boolean isFilledOutCorrectly() {
        return true;        
    }
    
    public ArrayList<RegisterComponent> getComponentList() {
        return componentList;
    }
    
    @Override
    public void setVisible(boolean aFlag) {
        if (aFlag) setComponentsEditable(true);           
        super.setVisible(aFlag);
    }

    public void setComponentsEditable(boolean editable) {
        if (!editable) updateComponents();
        for (RegisterComponent component: componentList) {
            component.setEditable(editable);
        }
    }
    
    public boolean isComponentsEditable() {
        return componentList.get(0).isEditable();
    }
    
    private void updateComponents() {
        for (RegisterComponent component : componentList) {
            component.updateTextLabelText();
        }
    }
}
