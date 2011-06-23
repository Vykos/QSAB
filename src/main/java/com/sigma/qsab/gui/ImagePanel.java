/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author ext.jonas.frogvall
 */

class ImagePanel extends JPanel {
    
    private Image img;   
    
    public ImagePanel(Image img) {
        this.img = img;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

}
