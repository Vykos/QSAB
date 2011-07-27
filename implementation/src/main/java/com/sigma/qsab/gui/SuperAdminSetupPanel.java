/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import com.sigma.qsab.exceptions.IncorrectGlitchException;
import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import com.sigma.qsab.glitches.GlitchLoader;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
 *
 * @author ext.jonas.frogvall
 */
public class SuperAdminSetupPanel extends JPanel {

    GUIStrings strings;
    CheckList glitchList;

    @SuppressWarnings("CallToThreadDumpStack")
    public SuperAdminSetupPanel(GUIStrings strings, ActionListener al) {
        this.strings = strings;
        setLayout(null);
        setBackground(GUIFields.BGCOLOR);
        Glitch[] glitchArray = null;
        try {
            glitchArray = GlitchLoader.getGlitches();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (glitchArray != null) {
            glitchList = ComponentMaker.makeGlitchCheckList(glitchArray);
            add(ComponentMaker.makeGlitchCheckListScrollPane(glitchList));
        }
        add(ComponentMaker.makeStandardButton(strings.getString(GUIStrings.SUPERADMINACCEPT),
                new Point(384, 644), al, "superadmin_accept"));
    }

    public void addGlitchesToGlitchManagers() throws IncorrectGlitchException {
        GlitchManagersSingleton.getInstance().clearGlitchManagers();
        ListModel model = glitchList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            CheckListItem item = (CheckListItem) (model.getElementAt(i));
            if (!item.isSelected()) {
                continue;
            }
            Glitch glitch = item.getGlitch();
            if ((glitch.getOverrideID() < Glitch.FUNCTIONMAX)
                    && (glitch.getOverrideID() > Glitch.FUNCTIONMIN)) {
                GlitchManagersSingleton.getInstance().getFunctionGlitchManager().putGlitch(glitch);
            } else if ((glitch.getOverrideID() < Glitch.GUIMAX)
                    && (glitch.getOverrideID() > Glitch.GUIMIN)) {
                GlitchManagersSingleton.getInstance().getGUIGlitchManager().putGlitch(glitch);
            } else {
                throw new IncorrectGlitchException("Glitch with incorrect ID found.");
            }
        }
    }
}
