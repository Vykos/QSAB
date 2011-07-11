package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.GlitchManagersSingleton;
import com.sigma.qsab.verifiers.RegisterVerifier;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel {
    private ArrayList<RegisterComponent> componentList;
    
    private GUIStrings gs;
    
    public RegisterPanel(GUIStrings gs, ActionListener al) {
        this.gs = gs;
        setLayout(null);    
        setBackground(GUIFields.BGCOLOR);
           
        componentList = ComponentMaker.makeRegisterComponentList(gs);
        
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
        for (RegisterComponent rc : componentList) {
            if (rc.getText().equals(gs.getString(GUIStrings.SOCIALID))) {
                return GlitchManagersSingleton.getInstance()
                        .getFunctionGlitchManager()
                        .isSocialIDCorrect(rc.getField().getText());                
            }
        }
        return false;        
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
