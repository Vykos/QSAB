package com.sigma.qsab.gui;

import com.sigma.qsab.data.Customer;
import com.sigma.qsab.glitches.FunctionGlitchManager;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel {
    
    private ArrayList<RegisterComponent> componentList;
    private GUIStrings strings;
    
    public RegisterPanel(GUIStrings strings, ActionListener al) {
        this.strings = strings;
        setLayout(null);
        setBackground(GUIFields.BGCOLOR);
        
        componentList = ComponentMaker.makeRegisterComponentList(strings);
        
        for (RegisterComponent component : componentList) {
            add(component.getTitleLabel());
            add(component.getTextLabel());
            add(component.getField());
        }
        
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.NEXT),
                new Point(774, 688), al, "register_next"));
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.PREVIOUS),
                new Point(64, 688), al, "register_previous"));
    }
    
    public void setAllFieldsError(boolean isError) {
        for (RegisterComponent rc : componentList) {
            rc.setFieldError(isError);
        }
    }
    
    public boolean isFilledOutCorrectly() {
        boolean isCorrect = true;
        RegisterComponent password = null;
        RegisterComponent passwordrepeat = null;
        FunctionGlitchManager glitchManager = GlitchManagersSingleton.getInstance().getFunctionGlitchManager();
        for (RegisterComponent rc : componentList) {
            if (rc.isMandatory()) {
                if (!glitchManager.isMandatoryRegisterFieldFilledOut(rc.getText())) {
                    rc.setFieldError(true);
                    isCorrect = false;
                }
            }
            if (rc.getTitle().equals(strings.getString(GUIStrings.SOCIALID))) {
                if (!glitchManager.isSocialIDCorrect(rc.getText())) {
                    rc.setFieldError(true);
                    isCorrect = false;
                }
            }
            if (rc.getTitle().equals(strings.getString(GUIStrings.PASSWORD))) {
                password = rc;
            }
            if (rc.getTitle().equals(strings.getString(GUIStrings.PASSWORDREPEAT))) {
                passwordrepeat = rc;
            }            
        }
        if (!glitchManager.arePasswordsEqual(password.getText(), passwordrepeat.getText())) {
            password.setFieldError(true);
            passwordrepeat.setFieldError(true);
            isCorrect = false;
        }
        return isCorrect;
    }
    
    public ArrayList<RegisterComponent> getComponentList() {
        return componentList;
    }
    
    @Override
    public void setVisible(boolean aFlag) {
        if (aFlag) {
            setComponentsEditable(true);
        }
        super.setVisible(aFlag);
    }
    
    public void setComponentsEditable(boolean editable) {
        if (!editable) {
            updateComponents();
        }
        for (RegisterComponent component : componentList) {
            component.setEditable(editable);
        }
    }
    
    public boolean isComponentsEditable() {
        return componentList.get(0).isEditable();
    }
    
    private void updateComponents() {
        for (RegisterComponent rc : componentList) {
            rc.updateTextLabelText();
        }
    }
    
    Customer getCustomer() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (RegisterComponent rc : componentList) {
            map.put(rc.getTitle(), rc.getText());
        }
        return new Customer(map.get(strings.getString(GUIStrings.FIRSTNAME)),
                map.get(strings.getString(GUIStrings.LASTNAME)),
                map.get(strings.getString(GUIStrings.SOCIALID)),
                map.get(strings.getString(GUIStrings.STREET)),
                map.get(strings.getString(GUIStrings.ZIPCODE)),
                map.get(strings.getString(GUIStrings.CITY)),
                map.get(strings.getString(GUIStrings.PHONE)),
                map.get(strings.getString(GUIStrings.CELLPHONE)),
                map.get(strings.getString(GUIStrings.EMAIL)),
                map.get(strings.getString(GUIStrings.PASSWORD)));        
    }
}
