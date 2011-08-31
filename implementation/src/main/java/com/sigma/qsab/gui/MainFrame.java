package com.sigma.qsab.gui;

import com.sigma.qsab.data.Customer;
import com.sigma.qsab.data.CustomerStorer;
import com.sigma.qsab.data.CustomerStorerImpl;
import com.sigma.qsab.exceptions.IncorrectGlitchException;
import com.sigma.qsab.glitches.GlitchManagersSingleton;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

    private Container container;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private SuperAdminSetupPanel superAdminSetupPanel;
    private ViewCustomerPanel viewCustomerPanel;
    private WelcomePanel welcomePanel;
    private GUIStrings strings;
    private CustomerStorer customers;

    @SuppressWarnings("CallToThreadDumpStack")
    public MainFrame(String title) {
        super(title);
        //JOptionPane.showMessageDialog(this, System.getProperty("java.class.path"));
        try {
            strings = new GUIStrings("/strings.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        customers = loadCustomers();
        setPreferredSize(new Dimension(GUIFields.W_APP, GUIFields.H_APP));
        /*setIconImage()*/
        container = getContentPane();
        container.setBackground(GUIFields.BGCOLOR);
        container.setLayout(null);

        welcomePanel = new WelcomePanel(new ImageIcon(getClass().getResource(
                "/login.png")).getImage(), strings, this);
        superAdminSetupPanel = new SuperAdminSetupPanel(strings, this);
        setBoundsForPanels(welcomePanel, superAdminSetupPanel);
        makePanelsInvisible(superAdminSetupPanel);
        makePanels();

        setResizable(false);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        handleCommand(action);
    }

    private void hideAllPanels() {
        makePanelsInvisible(welcomePanel, registerPanel, superAdminSetupPanel,
                loginPanel, viewCustomerPanel);
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

    private void makePanels() {
        container.removeAll();
        registerPanel = new RegisterPanel(strings, this);
        loginPanel = new LoginPanel(strings, this);
        viewCustomerPanel = new ViewCustomerPanel(strings, this);
        setBoundsForPanels(registerPanel, loginPanel, viewCustomerPanel);
        makePanelsInvisible(registerPanel, loginPanel, viewCustomerPanel);
        addPanelsToContainer(welcomePanel, superAdminSetupPanel, registerPanel,
                loginPanel, viewCustomerPanel);
    }

    private CustomerStorerImpl loadCustomers() {
        return new CustomerStorerImpl();
    }

    private void handleCommand(String action) {
        if (action.equals("login_next")) {
            handleLoginAttempt();
        } else if (action.equals("login_previous")) {
            handleLoginCancel();
        } else if (action.equals("register_next")) {
            handleRegistrationAttempt();
        } else if (action.equals("register_previous")) {
            handleRegistrationCancel();
        } else if (action.equals("superadmin_accept")) {
            handleSuperAdminChoosenGlitches();
        } else if (action.equals("viewcustomer_logout")){
            handleLogout();
        } else if (action.equals("welcome_superadmin")) {
            handleShowSuperAdminPanel();
        } else if (action.equals("welcome_register")) {
            handleShowRegisterPanel();
        } else if (action.equals("welcome_login")) {
            handleShowLoginPanel();
        }
    }

    private void handleLoginAttempt() {
        String id = loginPanel.getSocialID();
        Customer customer = customers.findCustomer(id);
        if (customer != null) {
            if (checkLoginPasswords(loginPanel.getPassword(), customer.getPassword())) {
                viewCustomerPanel.setCustomer(customer);
                hideAllPanels();
                viewCustomerPanel.setVisible(true);                
            } else {
                showMessageDialog(GUIStrings.LOGINERRORMESSAGE);
            }
        } else {
            showMessageDialog(GUIStrings.LOGINERRORMESSAGE);
        }
    }

    private boolean checkLoginPasswords(String attemptedPassword, String storedPassword) {
        return GlitchManagersSingleton.getInstance().getFunctionGlitchManager().compareLoginPasswords(attemptedPassword, storedPassword);
    }

    private void showMessageDialog(String GUIStringsField) {
        JOptionPane.showMessageDialog(this, strings.getString(GUIStringsField));
    }

    private void handleRegistrationAttempt() {
        if (registerPanel.isComponentsEditable()) {
            registerPanel.setAllFieldsError(false);
            if (registerPanel.isFilledOutCorrectly()) {
                if(!customers.addCustomer(registerPanel.getCustomer())) {
                    //showMessageDialog(GUIStrings.USERALREADYEXISTS);
                    System.out.println("Can't create customer:");
                    System.out.println(registerPanel.getCustomer().toString());
                }
                registerPanel.setComponentsEditable(false);
            } else {
                showMessageDialog(GUIStrings.REGISTERERRORMESSAGE);
            }
        } else {
            System.out.println("Nu borde den g\u00e5 vidare med en ny anv\u00e4ndare");
        }
    }

    private void handleLoginCancel() {
        hideAllPanels();
        welcomePanel.setVisible(true);
    }

    private void handleRegistrationCancel() {
        if (registerPanel.isComponentsEditable()) {
            hideAllPanels();
            welcomePanel.setVisible(true);
        } else {
            registerPanel.setComponentsEditable(true);
        }
    }

    @SuppressWarnings("CallToThreadDumpStack")
    private void handleSuperAdminChoosenGlitches() {
        try {
            superAdminSetupPanel.addGlitchesToGlitchManagers();
        } catch (IncorrectGlitchException ige) {
            ige.printStackTrace();
        }
        makePanels();
        hideAllPanels();
        welcomePanel.setVisible(true);
    }

    private void handleShowSuperAdminPanel() {
        hideAllPanels();
        superAdminSetupPanel.setVisible(true);
    }

    private void handleShowRegisterPanel() {
        hideAllPanels();
        registerPanel.setVisible(true);
    }

    private void handleShowLoginPanel() {
        hideAllPanels();
        loginPanel.setVisible(true);        
    }

    private void handleLogout() {
        hideAllPanels();
        welcomePanel.setVisible(true);
    }
}
