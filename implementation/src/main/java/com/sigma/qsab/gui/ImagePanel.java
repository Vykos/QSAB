package com.sigma.qsab.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
    
    private Image img;   
    
    public ImagePanel(Image img) {
        this.img = img;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

}
