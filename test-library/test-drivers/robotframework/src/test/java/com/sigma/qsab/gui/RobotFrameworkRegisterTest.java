package com.sigma.qsab.gui;

import com.sigma.qsab.gui.runner.UISpec4JGUIRunner;
import com.sigma.qsab.data.Customer;
import com.sigma.qsab.data.CustomerStorer;
import com.sigma.qsab.data.CustomerStorerImpl;
import com.sigma.qsab.gui.runner.GUIRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotFrameworkRegisterTest {
    
    private static GUIRunner runner;
    private String firstName;
    private String lastName;
    private String socialID;
    private String street;
    private String zipCode;
    private String city;
    private String phone;
    private String cellPhone;
    private String email;
    private String password;
    
    public void setUp() {
        RobotFrameworkRegisterTest.runner = new UISpec4JGUIRunner();
        runner.initiateGUIRunner();
    }

    public void tearDown() {
        runner.tearDownGUIRunner();
    }

    public void prepareRegisterStrings(String firstName, String lastName, String socialID,
            String street, String zipCode, String city, String phone,
            String cellPhone, String email, String password) {        
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialID = socialID;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
    }
    
    public void prepareLoginStrings(String socialID, String password) {        
        this.socialID = socialID;
        this.password = password;
    }

    public void fillOutRegisterForm() {
        findForm();
        fillOutForm();

        runner.clickButton("Nästa");
    }

    public void fillOutRegisterFormWithSelectedBug(String glitch) {
        selectGlitch(glitch);

        findForm();
        fillOutForm();

        runner.clickButton("Nästa");
    }

    public void logIn() {
        runner.clickButton("Logga in");
        runner.login(socialID, password);
        runner.clickButton("Logga in");
    }

    public void deleteCustomer() {
        deleteCustomerFromDatabase();
    }


    public void checkIfCustomerExists() {
        boolean expectedDoesCustomerExist = true;

        Customer customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        CustomerStorer customers = new CustomerStorerImpl();

        boolean actualDoesCustomerExist = customers.containsCustomer(customer);

        assertThat(actualDoesCustomerExist, is(expectedDoesCustomerExist));
        runner.pause(1000);
    }

    public void verifyLoggedIn() {
        runner.assertLoggedIn();
        runner.pause(3000);        
    }
    
    public void verifyDeletedCustomer() {
        boolean expectedDoesCustomerExist = false;

        Customer customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        CustomerStorer customers = new CustomerStorerImpl();

        boolean actualDoesCustomerExist = customers.containsCustomer(customer);

        assertThat(actualDoesCustomerExist, is(expectedDoesCustomerExist));
    }

    private void findForm() {
        runner.clickButton("Ny kund");
    }

    private void fillOutForm() {
        runner.fillInName(firstName, lastName);
        runner.fillInSocialID(socialID);
        runner.fillInAddress(street, zipCode, city);
        runner.fillInPhoneNumber(phone);
        runner.fillInCellPhoneNumber(cellPhone);
        runner.fillInEmail(email);
        runner.fillInPasswordTwice(password);
    }

    private void selectGlitch(String glitch) {
        runner.clickButton("Välj buggar");
        runner.selectItemFromGlitchList(glitch);
        runner.clickButton("Applicera valda fel");
    }

    private void deleteCustomerFromDatabase() {
        CustomerStorer customers = new CustomerStorerImpl();
        Customer customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        if (customers.deleteCustomer(customer)) {
            System.out.println("Deleted customer:\n" + customer);
        }
    }
}
