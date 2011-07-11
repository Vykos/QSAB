/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import com.sigma.qsab.glitches.customglitches.GlitchList;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/**
 *
 * @author ext.jonas.frogvall
 */
public class SuperAdminSetupPanel extends JPanel {

    GUIStrings gs;
    CheckList glitchList;

    public SuperAdminSetupPanel(GUIStrings gs, ActionListener al) {
        this.gs = gs;
        setLayout(null);
        setBackground(GUIFields.BGCOLOR);
        glitchList = ComponentMaker.makeGlitchCheckList(GlitchList.getAllGlitches());
        JScrollPane scrollPane = ComponentMaker.makeGlitchCheckListScrollPane(
                glitchList);
        add(scrollPane);
        add(ComponentMaker.makeStandardButton(gs.getString(GUIStrings.SUPERADMINACCEPT),
                new Point(384, 644), al, "superadmin_accept"));
    }

    public void addGlitchesToGlitchManagers() {
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
            } else {
                GlitchManagersSingleton.getInstance().getGUIGlitchManager().putGlitch(glitch);
            }
        }
    }
}
