package com.sigma.qsab.gui.runner;

import com.sigma.qsab.gui.GUIStrings;
import java.awt.Component;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import junit.framework.Assert;
import org.uispec4j.Button;
import org.uispec4j.ListBox;
import org.uispec4j.PasswordField;
import org.uispec4j.TextBox;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.finder.ComponentMatcher;

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
    public void clickButton(final String buttonText) {
        ComponentMatcher buttonMatcher = new ComponentMatcher() {

            @Override
            public boolean matches(Component component) {
                String componentText;
                try {
                    componentText = ((JButton) component).getText();
                } catch (Exception ex) {
                    return false;
                }
                if (componentText == null) {
                    return false;
                }
                return ((componentText.equals(buttonText))
                        && (component.isShowing()));
            }
        };
        Button button = window.getButton(buttonMatcher);
        button.click();
    }

    @Override
    public void selectItemFromGlitchList(String item) {
        ListBox listBox = window.getListBox("superadmin_glitchlist");
        int nrOfComponents = listBox.getSize();
        int indexOfItem = 0;
        for (; indexOfItem < nrOfComponents; indexOfItem++) {
            if (((JCheckBox) (listBox.getSwingRendererComponentAt(0))).getText().equals(item)) {
                break;
            }
        }
        listBox.click(indexOfItem);
    }

    @Override
    public void fillInName(String firstName, String lastName) {
        findTextBox("field_" + gs.getString(GUIStrings.FIRSTNAME)).setText(firstName);
        findTextBox("field_" + gs.getString(GUIStrings.LASTNAME)).setText(lastName);
    }

    @Override
    public void fillInSocialID(String socialID) {
        findTextBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText(socialID);
    }

    @Override
    public void fillInAddress(String street, String zipcode, String city) {
        findTextBox("field_" + gs.getString(GUIStrings.STREET)).setText(street);
        findTextBox("field_" + gs.getString(GUIStrings.ZIPCODE)).setText(zipcode);
        findTextBox("field_" + gs.getString(GUIStrings.CITY)).setText(city);
    }

    @Override
    public void fillInPhoneNumber(String phoneNumber) {
        findTextBox("field_" + gs.getString(GUIStrings.PHONE)).setText(phoneNumber);
    }

    @Override
    public void fillInCellPhoneNumber(String cellPhoneNumber) {
        findTextBox("field_" + gs.getString(GUIStrings.CELLPHONE)).setText(cellPhoneNumber);
    }

    @Override
    public void fillInEmail(String email) {
        findTextBox("field_" + gs.getString(GUIStrings.EMAIL)).setText(email);
    }

    @Override
    public void fillInPasswordTwice(String password) {
        findPasswordField("field_" + gs.getString(GUIStrings.PASSWORD)).setPassword(password);
        findPasswordField("field_" + gs.getString(GUIStrings.PASSWORDREPEAT)).setPassword(password);
    }

    @Override
    public void assertName(String firstName, String lastName) {
        assertTrue("First name is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.FIRSTNAME), firstName));
        assertTrue("Last name is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.LASTNAME), lastName));
    }

    @Override
    public void assertSocialID(String socialID) {
        assertTrue("Social ID is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.SOCIALID), socialID));
    }

    @Override
    public void assertAddress(String street, String zipcode, String city) {
        assertTrue("Street is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.STREET), street));
        assertTrue("Zip code is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.ZIPCODE), zipcode));
        assertTrue("City is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.CITY), city));
    }

    @Override
    public void assertPhoneNumber(String phoneNumber) {
        assertTrue("Phone number is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.PHONE), phoneNumber));
    }

    @Override
    public void assertCellPhoneNumber(String cellPhoneNumber) {
        assertTrue("Cellphone number is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.CELLPHONE), cellPhoneNumber));
    }

    @Override
    public void assertEmail(String email) {
        assertTrue("E-mail is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.EMAIL), email));
    }

    @Override
    public void assertPasswords(String password) {
        assertTrue("Password is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.PASSWORD), password));
        assertTrue("Repeated password is incorrect", isTextBoxCorrectlyFilledOut("text_" + gs.getString(GUIStrings.PASSWORDREPEAT), password));
    }

    @Override
    public void login(String socialID, String password) {
        findTextBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText(socialID);
        findPasswordField("field_" + gs.getString(GUIStrings.PASSWORD)).setPassword(password);
    }

    @SuppressWarnings("CallToThreadDumpStack")
    @Override
    public void pause(long timeToSleep) {
        //do nothing
    }

    private TextBox findTextBox(final String textBoxName) {
        ComponentMatcher textBoxMatcher = new ComponentMatcher() {

            @Override
            public boolean matches(Component component) {
                String componentName = component.getName();
                if (componentName == null) {
                    return false;
                }
                return ((componentName.equals(textBoxName))
                        && (component.isShowing()));
            }
        };
        return window.getTextBox(textBoxMatcher);
    }

    private PasswordField findPasswordField(final String passwordFieldName) {
        ComponentMatcher textBoxMatcher = new ComponentMatcher() {

            @Override
            public boolean matches(Component component) {
                String componentName = component.getName();
                if (componentName == null) {
                    return false;
                }
                return ((componentName.equals(passwordFieldName))
                        && (component.isShowing()));
            }
        };
        return window.getPasswordField(textBoxMatcher);
    }

    private boolean isTextBoxCorrectlyFilledOut(String labelName, String text) {
        return window.getTextBox(labelName).getText().equals(text);
    }

    @Override
    public void assertLoggedIn() {
        final String logOutButtonText = gs.getString(GUIStrings.LOGOUT);
        ComponentMatcher buttonMatcher = new ComponentMatcher() {

            @Override
            public boolean matches(Component component) {
                String componentText;
                try {
                    componentText = ((JButton) component).getText();
                } catch (Exception ex) {
                    return false;
                }
                if (componentText == null) {
                    return false;
                }
                return ((componentText.equals(logOutButtonText))
                        && (component.isShowing()));
            }
        };
        try {
            window.getButton(buttonMatcher);
        } catch (Exception ex) {
            Assert.assertNotNull("Customer did not get logged in.", null);
        }
    }
}
