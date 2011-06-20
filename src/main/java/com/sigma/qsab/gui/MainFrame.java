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
    
    private JPanel registerPanel;
    private ImagePanel welcomePanel;
            
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
        container.setLayout(null);
        
        /*WELCOME PANEL*/
        welcomePanel = new ImagePanel(new ImageIcon(getClass().getResource("/com/sigma/qsab/images/login.png")).getImage());
        welcomePanel.setBackground(bgColor);
        welcomePanel.setLayout(null);
        JButton loginButton = new JButton("Logga in");
        loginButton.setBackground(bgColor);        
        loginButton.setBounds(600, 400, buttonWidth, buttonHeight);
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        welcomePanel.add(loginButton);
        JButton registerButton = new JButton("Ny kund");
        registerButton.setBackground(bgColor);        
        registerButton.setBounds(600, 450, buttonWidth, buttonHeight);
        registerButton.setActionCommand("register");
        registerButton.addActionListener(this);        
        welcomePanel.add(registerButton);
        
        /*REGISTER PANEL*/
        registerPanel = new JPanel(new FlowLayout());
        JButton testButton = new JButton("Test");
        testButton.setBackground(bgColor);        
        testButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        testButton.setActionCommand("test");
        testButton.addActionListener(this);
        registerPanel.add(testButton);
        
        welcomePanel.setBounds(0, 0, width, height);
        registerPanel.setBounds(0, 0, width, height);
        
        registerPanel.setVisible(false);
        
        container.add(welcomePanel);        
        container.add(registerPanel);
        
        pack();
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent event){
                dispose();                
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        if(action.equals("register")){
            hideAllPanels();
            registerPanel.setVisible(true);
        }
    }

    private void hideAllPanels() {
        welcomePanel.setVisible(false);
        registerPanel.setVisible(false);
    }
    
}
