package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentMaker {

    public static JButton makeStandardButton(String text, Point position,
            ActionListener listener, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(GUIFields.BGCOLOR);
        button.setBounds(position.x, position.y, GUIFields.W_BUTTON,
                GUIFields.H_BUTTON);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        button.setName(actionCommand);
        return button;
    }

    public static ArrayList<RegisterComponent> makeRegisterComponentList(
            GUIStrings strings) {
        ArrayList<RegisterComponent> componentList = new ArrayList<RegisterComponent>();
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.FIRSTNAME), true, 0));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.LASTNAME), true, 1));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.SOCIALID), true, 2));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.STREET), false, 3));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.ZIPCODE), false, 4));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.CITY), false, 5));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.PHONE), false, 6));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.CELLPHONE), true, 7));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makeTextRegisterComponent(
                strings.getString(GUIStrings.EMAIL), true, 8));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makePasswordRegisterComponent(
                strings.getString(GUIStrings.PASSWORD), true, 9));
        componentList.add(GlitchManagersSingleton.getInstance().getGUIGlitchManager().makePasswordRegisterComponent(
                strings.getString(GUIStrings.PASSWORDREPEAT), true, 10));
        return componentList;
    }

    public static RegisterComponent makeTextRegisterComponent(String text,
            boolean mandatory, int componentNR) {
        return RegisterComponent.newTextFieldComponent(
                text, mandatory, GUIFields.X_REGISTERCOMPONENT,
                GUIFields.Y_REGISTERCOMPONENT + componentNR
                * (GUIFields.H_LABEL + GUIFields.VERTICALGAP));
    }

    public static RegisterComponent makePasswordRegisterComponent(String text,
            boolean mandatory, int componentNR) {
        return RegisterComponent.newPasswordFieldComponent(
                text, mandatory, GUIFields.X_REGISTERCOMPONENT,
                GUIFields.Y_REGISTERCOMPONENT + componentNR
                * (GUIFields.H_LABEL + GUIFields.VERTICALGAP));
    }

    public static CheckList makeGlitchCheckList(Glitch[] glitchArray) {
        CheckList list = new CheckList(glitchArray);
        list.setBounds(GUIFields.X_SUPERADMINLIST, GUIFields.Y_SUPERADMINLIST,
                GUIFields.W_SUPERADMINLIST, GUIFields.H_SUPERADMINLIST);
        return list;
    }

    public static JScrollPane makeGlitchCheckListScrollPane(CheckList list) {
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(GUIFields.X_SUPERADMINLIST, GUIFields.Y_SUPERADMINLIST,
                GUIFields.W_SUPERADMINLIST, GUIFields.H_SUPERADMINLIST);
        return scrollPane;
    }
    
    public static JLabel makeLabel(String text, Point position) {
        JLabel label = new JLabel(text);
        label.setBackground(GUIFields.BGCOLOR);
        label.setBounds(position.x,
                position.y, GUIFields.W_LABEL, GUIFields.H_LABEL);
        label.setName("label_" + text);
        return label;
    }
    
    public static JTextField makeTextField(String text, Point position, String name) {
        JTextField field = new JTextField(text);
        field.setBackground(GUIFields.BGCOLOR);
        field.setBounds(position.x, position.y, 
                GUIFields.W_TEXTFIELD, GUIFields.H_TEXTFIELD);        
        field.setName(name);
        return field;
    }
    
    public static JPasswordField makePasswordField(String text, Point position, String name) {
        JPasswordField field = new JPasswordField(text);
        field.setBackground(GUIFields.BGCOLOR);
        field.setBounds(position.x,position.y, 
                GUIFields.W_TEXTFIELD, GUIFields.H_TEXTFIELD);
        field.setName(name);
        return field;
    }

    public static JTextArea makeTextArea(String text, Point position, String name) {
        JTextArea area = new JTextArea();
        area.setBackground(GUIFields.BGCOLOR);
        area.setBounds(position.x, position.y, 
                GUIFields.W_TEXTAREA, GUIFields.H_TEXTAREA);
        area.setName(name);
        return area;
    }
}
