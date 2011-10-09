package com.sigma.qsab.gui;

import com.sigma.qsab.data.Customer;
import com.sigma.qsab.data.CustomerStorer;
import com.sigma.qsab.data.CustomerStorerImpl;
import com.sigma.qsab.gui.runner.GUIRunner;

/*import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;*/

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
    
    /*@Before
    public void setUp() {
        runner.initiateGUIRunner();
    }

    @After
    public void tearDown() {
        runner.tearDownGUIRunner();
    }*/

    public RobotFrameworkRegisterTest() {
        //RobotFrameworkRegisterTest.runner = new FESTGUIRunner();
    }

    public void prepareStrings(String firstName, String lastName, String socialID,
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
    
    public void fillOutRegisterForm() {
        findForm();
        fillOutForm();

        runner.clickButton("Nästa");
    }
    
    public void checkIfCustomerExists() {
        boolean expectedDoesCustomerExist = true;

        Customer customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        CustomerStorer customers = new CustomerStorerImpl();

        boolean actualDoesCustomerExist = customers.containsCustomer(customer);

        //assertThat(actualDoesCustomerExist, is(expectedDoesCustomerExist));
        runner.pause(1000);
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
}
