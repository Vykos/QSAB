package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.GlitchManagersSingleton;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class ComponentMaker {

    public static JButton makeStandardButton(String text, Point position,
            ActionListener listener, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(GUIFields.BGCOLOR);
        button.setBounds(position.x, position.y, GUIFields.BUTTONWIDTH,
                GUIFields.BUTTONHEIGHT);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        button.setName(actionCommand);
        return button;
    }

    public static ArrayList<RegisterComponent> makeRegisterComponentList(
            GUIStrings gs) {
        ArrayList<RegisterComponent> componentList = new ArrayList<RegisterComponent>();
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.FIRSTNAME), true, 0));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.LASTNAME), true, 1));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.SOCIALID), true, 2));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.STREET), false, 3));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.ZIPCODE), false, 4));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.CITY), false, 5));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.PHONE), false, 6));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.CELLPHONE), true, 7));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makeTextRegisterComponent(
                gs.getString(GUIStrings.EMAIL), true, 8));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makePasswordRegisterComponent(
                gs.getString(GUIStrings.PASSWORD), true, 9));
        componentList.add(GlitchManagersSingleton.getInstance()
                .getGUIGlitchManager().makePasswordRegisterComponent(
                gs.getString(GUIStrings.PASSWORDREPEAT), true, 10));                              
        return componentList;
    }

    public static RegisterComponent makeTextRegisterComponent(String text,
            boolean mandatory, int componentNR) {
        return RegisterComponent.newTextFieldComponent(
                text, mandatory, GUIFields.X_REGISTERCOMPONENT,
                GUIFields.Y_REGISTERCOMPONENT + componentNR
                * (GUIFields.LABELHEIGHT + GUIFields.VERTICALGAP));
    }

    public static RegisterComponent makePasswordRegisterComponent(String text,
            boolean mandatory, int componentNR) {
        return RegisterComponent.newPasswordFieldComponent(
                text, mandatory, GUIFields.X_REGISTERCOMPONENT,
                GUIFields.Y_REGISTERCOMPONENT + componentNR
                * (GUIFields.LABELHEIGHT + GUIFields.VERTICALGAP));
    }
}
