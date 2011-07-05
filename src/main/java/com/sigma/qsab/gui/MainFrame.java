package com.sigma.qsab.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

    private Container container;
    private RegisterPanel registerPanel;
    private SuperAdminSetupPanel superAdminSetupPanel;
    private WelcomePanel welcomePanel;    
    private GUIStrings strings;

    public MainFrame() {
        this("No title");
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public MainFrame(String title) {
        super(title);
        try {
            strings = new GUIStrings("/strings.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(GUIFields.W_APP, GUIFields.H_APP));
        /*setIconImage()*/
        container = getContentPane();
        container.setBackground(GUIFields.BGCOLOR);
        container.setLayout(null);

        welcomePanel = new WelcomePanel(new ImageIcon(getClass().getResource(
                "/login.png")).getImage(), strings, this);
        registerPanel = new RegisterPanel(strings, this);
        superAdminSetupPanel = new SuperAdminSetupPanel(strings, this);
        

        setBoundsForPanels(welcomePanel, registerPanel, superAdminSetupPanel);
        makePanelsInvisible(registerPanel, superAdminSetupPanel);
        addPanelsToContainer(welcomePanel, registerPanel, superAdminSetupPanel);

        setResizable(false);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("register_next")) {
            if (registerPanel.isComponentsEditable()) {
                if (registerPanel.isFilledOutCorrectly()) {
                    registerPanel.setComponentsEditable(false);
                } else {
                    System.out.println("Nu borde den klaga på felaktig data");
                }
            } else {
                System.out.println("Nu borde den gå vidare med en ny användare");
            }
        } else if (action.equals("register_previous")) {
            if (registerPanel.isComponentsEditable()) {
                hideAllPanels();
                welcomePanel.setVisible(true);
            } else {
                registerPanel.setComponentsEditable(true);
            }
        } else if (action.equals("superadmin_accept")) {
            superAdminSetupPanel.addGlitchesToGlitchManagers();
            hideAllPanels();
            welcomePanel.setVisible(true);
        } else if (action.equals("welcome_login")) {
            hideAllPanels();
            superAdminSetupPanel.setVisible(true);
        } else if (action.equals("welcome_register")) {
            hideAllPanels();
            registerPanel.setVisible(true);
        }

    }

    private void hideAllPanels() {
        makePanelsInvisible(welcomePanel, registerPanel, superAdminSetupPanel);        
    }

    private void setBoundsForPanels(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBounds(0, 0, GUIFields.W_APP, GUIFields.H_APP);
        }
    }

    private void makePanelsInvisible(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setVisible(false);
        }
    }

    private void addPanelsToContainer(JPanel... panels) {
        for (JPanel panel : panels) {
            container.add(panel);
        }
    }
}
