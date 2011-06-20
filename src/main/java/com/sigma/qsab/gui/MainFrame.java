/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ext.jonas.frogvall
 */
public class MainFrame extends JFrame implements ActionListener {
    private Container container;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
            
    private final Color bgColor = Color.WHITE;
    private final int width = 1024;
    private final int height = 768;
    private final int buttonWidth = 180;
    private final int buttonHeight = 30;
    
    public MainFrame(String title) {
        super(title);
        setPreferredSize(new Dimension(width, height));
        /*setIconImage()*/
        container = getContentPane();
        container.setBackground(bgColor);
        ImagePanel welcomePanel = new ImagePanel(new ImageIcon(getClass().getResource("/com/sigma/qsab/images/login.png")).getImage());
        welcomePanel.setBackground(bgColor);
        welcomePanel.setLayout(null);
        JButton loginButton = new JButton("Logga in");
        loginButton.setBackground(bgColor);        
        loginButton.setBounds(600, 400, buttonWidth, buttonHeight);
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        welcomePanel.add(loginButton);
        JButton newCustomerButton = new JButton("Ny kund");
        newCustomerButton.setBackground(bgColor);        
        newCustomerButton.setBounds(600, 450, buttonWidth, buttonHeight);
        newCustomerButton.setActionCommand("newcustomer");
        newCustomerButton.addActionListener(this);
        welcomePanel.add(newCustomerButton);
        
        container.add(welcomePanel, BorderLayout.CENTER);        
        pack();
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent event){
                dispose();                
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e){}
}
