package com.sigma.qsab.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

    private Container container;
    private RegisterPanel registerPanel;
    private WelcomePanel welcomePanel;
    private GUIStrings strings;

    public MainFrame() {
        this("No title");
    }

    public MainFrame(String title) {
        super(title);
        try {
            strings = new GUIStrings("/com/sigma/qsab/values/strings.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(GUIFields.WIDTH, GUIFields.HEIGHT));
        /*setIconImage()*/
        container = getContentPane();
        container.setBackground(GUIFields.BGCOLOR);
        container.setLayout(null);

        welcomePanel = new WelcomePanel(new ImageIcon(getClass().getResource(
                "/com/sigma/qsab/images/login.png")).getImage(), strings, this);
        registerPanel = new RegisterPanel(strings, this);

        setBoundsForPanels(welcomePanel, registerPanel);
        makePanelsInvisible(registerPanel);
        addPanelsToContainer(welcomePanel, registerPanel);

        setResizable(false);
        pack();
        setVisible(true);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
                System.exit(0);
            }
        });
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
        } else if (action.equals("welcome_register")) {
            hideAllPanels();
            registerPanel.setVisible(true);
        }

    }

    private void hideAllPanels() {
        welcomePanel.setVisible(false);
        registerPanel.setVisible(false);
    }

    private void setBoundsForPanels(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBounds(0, 0, GUIFields.WIDTH, GUIFields.HEIGHT);
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
