package com.sigma.qsab.gui;

import com.sigma.qsab.gui.runner.GUITestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterTest {

    private static GUITestRunner runner;
    private String firstname;
    private String lastname;
    private String socialID;
    private String street;
    private String zipCode;
    private String city;
    private String phone;
    private String cellPhone;
    private String email;
    private String password;

    @BeforeClass
    public static void setUpOnce() {
        runner = new GUITestRunner();
    }

    @Before
    public void setUp() {
        runner.initiate();
    }

    @After
    public void tearDown() {
        runner.tearDown();
    }

    @Test
    public void testRegisterFillOut() {
        findForm();
        prepareStrings();
        fillOutForm();

        runner.clickButton("register_next");
        runner.pause(1000);

        assertForm();
        
        runner.clickButton("register_previous");
        runner.clickButton("register_previous");
        runner.clickButton("welcome_login");
        
        login();
        
        runner.clickButton("login_next");
        
        runner.pause(3000);
    }

    @Test
    public void testFailRegisterFillOut() {
        selectGlitch();
        findForm();
        prepareErroneousStrings();
        fillOutForm();

        runner.clickButton("register_next");
        runner.pause(1000);       

        assertForm();
        
        runner.clickButton("register_previous");
        runner.clickButton("register_previous");
        runner.clickButton("welcome_login");
        
        login();
        
        runner.clickButton("login_next");
        
        runner.pause(3000);
    }

    private void selectGlitch() {
        runner.clickButton("welcome_superadmin");
        runner.selectItemFromGlitchList("Formateringsfel i personnummer");
        runner.clickButton("superadmin_accept");
    }

    private void findForm() {
        runner.clickButton("welcome_register");
    }

    private void prepareStrings() {
        firstname = "Test";
        lastname = "Testsson";
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
        runner.fillInName(firstname, lastname);
        runner.fillInSocialID(socialID);
        runner.fillInAddress(street, zipCode, city);
        runner.fillInPhoneNumber(phone);
        runner.fillInCellPhoneNumber(cellPhone);
        runner.fillInEmail(email);
        runner.fillInPasswordTwice(password);
    }

    private void assertForm() {
        runner.assertName(firstname, lastname);
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
}
