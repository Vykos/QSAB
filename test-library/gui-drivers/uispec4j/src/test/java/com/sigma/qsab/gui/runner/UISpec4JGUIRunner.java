package com.sigma.qsab.gui.runner;

import com.sigma.qsab.gui.GUIStrings;
import java.io.IOException;
import org.uispec4j.Button;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;

public class UISpec4JGUIRunner extends UISpecTestCase implements GUIRunner {
    Window window;
    GUIStrings gs;

    @SuppressWarnings("CallToThreadDumpStack")
    public UISpec4JGUIRunner() {
        try {
            gs = new GUIStrings("/strings.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
    @Override
    public void initiateGUIRunner() {
        setAdapter(new QSABAdapter());
        window = getMainWindow();
    }

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void tearDownGUIRunner() {
        try {
            tearDown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clickButton(String buttonText) {
        System.out.println("==== CLICKING BUTTON: " + buttonText + " ====");
        Button button = window.getButton(buttonText);
        button.click();
    }

    @Override
    public void selectItemFromGlitchList(String item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInName(String firstname, String lastname) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInSocialID(String socialID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInAddress(String street, String zipcode, String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInPhoneNumber(String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInCellPhoneNumber(String cellPhoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fillInPasswordTwice(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertName(String firstname, String lastname) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertSocialID(String socialID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertAddress(String street, String zipcode, String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertPhoneNumber(String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertCellPhoneNumber(String cellPhoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertPasswords(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void login(String socialID, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pause(long timeToSleep) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
