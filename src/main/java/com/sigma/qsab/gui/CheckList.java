/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.Glitch;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ext.jonas.frogvall
 */
public class CheckList extends JList {

    public CheckList(Glitch[] glitchList) {        
        super();
        CheckListItem[] items = new CheckListItem[glitchList.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new CheckListItem(glitchList[i]);            
        }
        setName("superadmin_glitchlist");
        setListData(items);
        setCellRenderer(new CheckListCellRenderer());
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {                
                int index = locationToIndex(event.getPoint());
                CheckListItem item =
                        (CheckListItem) getModel().getElementAt(index);
                item.setSelected(!item.isSelected());
                repaint(getCellBounds(index, index));
            }
        });
    }
}
