package com.sigma.qsab.gui;

import com.sigma.qsab.data.Customer;
import com.sigma.qsab.data.CustomerStorer;
import com.sigma.qsab.data.CustomerStorerImpl;
import com.sigma.qsab.gui.runner.FESTGUIRunner;
import com.sigma.qsab.gui.runner.GUIRunner;
import com.sigma.qsab.gui.runner.SikuliGUIRunner;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class JUnitRegisterTest {

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

    /*@BeforeClass
    public static void setUpOnce() {
        runner = new FESTGUIRunner();        
    }*/

    @Before
    public void setUp() {
        runner.initiate();                  
    }

    @After
    public void tearDown() {
        runner.tearDown();
        cleanCustomersData();     
    }

    public JUnitRegisterTest(GUIRunner runner) {
        JUnitRegisterTest.runner = runner;
    }

    @Test
    public void testRegisterFillOut() {
        findForm();
        prepareStrings();
        fillOutForm();

        runner.clickButton("Nästa");
        runner.pause(1000);

        assertForm();
        
        runner.clickButton("Föregående");
        runner.clickButton("Föregående");
        runner.clickButton("Logga in");
        
        login();
        
        runner.clickButton("Logga in");
        
        runner.pause(3000);
    }

    @Test
    public void testFailRegisterFillOut() {
        selectGlitch();
        findForm();
        prepareErroneousStrings();
        fillOutForm();

        runner.clickButton("Nästa");
        runner.pause(1000);

        assertForm();
        
        runner.clickButton("Föregående");
        runner.clickButton("Föregående");
        runner.clickButton("Logga in");
        
        login();
        
        runner.clickButton("Logga in");
        
        runner.pause(3000);
    }

    private void selectGlitch() {
        runner.clickButton("Välj buggar");
        runner.selectItemFromGlitchList("Formateringsfel i personnummer");
        runner.clickButton("Applicera valda fel");
    }

    private void findForm() {
        runner.clickButton("Ny kund");
    }

    private void prepareStrings() {
        firstName = "Test";
        lastName = "Testsson";
        socialID = "121212-1212";
        street = "Testgatan 55";
        zipCode = "12345";
        city = "Testort";
        phone = "08-123456";
        cellPhone = "073-123456";
        email = "test@test.com";
        password = "123456";
    }

    private void prepareErroneousStrings() {
        prepareStrings();
        socialID = "1212-121212";        
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

    private void assertForm() {
        runner.assertName(firstName, lastName);
        runner.assertSocialID(socialID);
        runner.assertAddress(street, zipCode, city);
        runner.assertPhoneNumber(phone);
        runner.assertCellPhoneNumber(cellPhone);
        runner.assertEmail(email);
        runner.assertPasswords(password);
    }

    private void login() {
        runner.login(socialID, password);
    }

    private void cleanCustomersData() {
        prepareStrings();
        CustomerStorer customers = new CustomerStorerImpl();
        Customer customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        if (customers.deleteCustomer(customer))
            System.out.println("Deleted customer:\n" + customer);
        prepareErroneousStrings();
        customer = new Customer(firstName, lastName, socialID, street, zipCode, city, phone, cellPhone, email, password);
        if (customers.deleteCustomer(customer))
            System.out.println("Deleted customer:\n" + customer);
    }
    
    @Parameterized.Parameters
    public static Collection<GUIRunner[]> runners() {
        List<GUIRunner[]> runners = new LinkedList<GUIRunner[]>();
        //runners.add(new GUIRunner[]{new SikuliGUIRunner()});
        runners.add(new GUIRunner[]{new FESTGUIRunner()});        

        return runners;
    }
}
