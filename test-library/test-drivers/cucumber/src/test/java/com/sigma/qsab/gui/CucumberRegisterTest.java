package com.sigma.qsab.gui;

import com.sigma.qsab.gui.runner.FESTGUIRunner;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import com.sigma.qsab.gui.runner.GUIRunner;
import cucumber.annotation.sv.Givet;
import cucumber.annotation.sv.När;
import cucumber.annotation.sv.Så;
import cucumber.junit.Cucumber;
import cucumber.junit.Feature;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Feature(value = "RegisterTest.feature")
public class CucumberRegisterTest {

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

    @Before
    public void setUp() {
        runner.initiate();
    }

    @After
    public void tearDown() {
        runner.tearDown();
    }

    public CucumberRegisterTest() {
        CucumberRegisterTest.runner = new FESTGUIRunner();
    }
    /*
    @Givet("^en kund med f�rnamnet \"([A-z]*)\", efternamnet \"([A-z]*)\", personnumret "
    + "\"([0-9]*\\-[0-9]*)\", som bor p� gatan \"([A-z]* [0-9]*)\" med postnummer \"([0-9]*)\" "
    + "och orten \"([A-z]*)\", har telefonnumret \"([0-9]*\\-[0-9]*)\", mobilnumret "
    + "\"([0-9]*\\-[0-9]*)\", mejladressen \"([a-z]*@[a-z]*\\.[a-z]*)\" och anv�nder l�senordet "
    + "\"([0-9]*)\".$")     
     */

    @Givet("^en kund med förnamnet \"(.*)\", efternamnet \"(.*)\", personnumret "
    + "\"(.*)\", som bor på gatan \"(.*)\" med postnummer \"(.*)\" "
    + "och orten \"(.*)\", har telefonnumret \"(.*)\", mobilnumret "
    + "\"(.*)\", mejladressen \"(.*)\" och använder lösenordet "
    + "\"(.*)\".$")
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

    @När("^kunden fyller i registreringsformuläret och klickar \"Nästa\".$")
    public void fillOutRegisterForm() {
        findForm();        
        fillOutForm();

        runner.clickButton("Nästa");
    }
    
    @Så("^skapas en ny kund med ovanstående information.$")
    public void checkIfCustomerExists() {
    
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