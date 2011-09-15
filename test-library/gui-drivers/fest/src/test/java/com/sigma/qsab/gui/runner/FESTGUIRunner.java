package com.sigma.qsab.gui.runner;

import com.sigma.qsab.QSAB;
import com.sigma.qsab.gui.GUIStrings;
import com.sigma.qsab.gui.MainFrame;
import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;

import java.io.IOException;
import javax.swing.JButton;
import org.fest.swing.core.GenericTypeMatcher;

public class FESTGUIRunner extends GUIRunner {

    private GUIStrings gs;
    private EmergencyAbortListener listener;
    private FrameFixture window;

    @Override
    public void initiate() {
        MainFrame frame = GuiActionRunner.execute(new GuiQuery<MainFrame>() {

            @Override
            protected MainFrame executeInEDT() {
                return (new QSAB()).getMainFrame();
            }
        });
        window = new FrameFixture(frame);
        listener = EmergencyAbortListener.registerInToolkit();
    }

    @Override
    public void tearDown() {
        listener.unregister();
        window.cleanUp();
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public FESTGUIRunner() {
        FailOnThreadViolationRepaintManager.install();
        try {
            gs = new GUIStrings("/strings.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clickButton(final String buttonText) {
        /* SKRIV OM SÅ FUNKTIONEN TAR EN KNAPPTEXT ISTÄLLET */
        /*        JButtonFixture button;
        
        button = window.button(buttonText);
        button.click();*/
        GenericTypeMatcher<JButton> textMatcher =
                new GenericTypeMatcher<JButton>(JButton.class) {

                    @Override
                    protected boolean isMatching(JButton button) {                        
                        return ((button.isShowing()) &&
                            (buttonText.equals(button.getText())));                        
                    }
                };
        window.button(textMatcher).click();
    }

    @Override
    public void selectItemFromGlitchList(String item) {
        window.list("superadmin_glitchlist").clickItem(item);
    }

    @Override
    public void fillInName(String firstname, String lastname) {
        window.textBox("field_" + gs.getString(GUIStrings.FIRSTNAME)).setText(firstname);
        window.textBox("field_" + gs.getString(GUIStrings.LASTNAME)).setText(lastname);
    }

    @Override
    public void fillInSocialID(String socialID) {
        window.textBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText(socialID);
    }

    @Override
    public void fillInAddress(String street, String zipcode, String city) {
        window.textBox("field_" + gs.getString(GUIStrings.STREET)).setText(street);
        window.textBox("field_" + gs.getString(GUIStrings.ZIPCODE)).setText(zipcode);
        window.textBox("field_" + gs.getString(GUIStrings.CITY)).setText(city);
    }

    @Override
    public void fillInPhoneNumber(String phoneNumber) {
        window.textBox("field_" + gs.getString(GUIStrings.PHONE)).setText(phoneNumber);
    }

    @Override
    public void fillInCellPhoneNumber(String cellPhoneNumber) {
        window.textBox("field_" + gs.getString(GUIStrings.CELLPHONE)).setText(cellPhoneNumber);
    }

    @Override
    public void fillInEmail(String email) {
        window.textBox("field_" + gs.getString(GUIStrings.EMAIL)).setText(email);
    }

    @Override
    public void fillInPasswordTwice(String password) {
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORD)).setText(password);
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORDREPEAT)).setText(password);
    }

    @Override
    public void assertName(String firstname, String lastname) {
        window.label("text_" + gs.getString(GUIStrings.FIRSTNAME)).requireText(firstname);
        window.label("text_" + gs.getString(GUIStrings.LASTNAME)).requireText(lastname);
    }

    @Override
    public void assertSocialID(String socialID) {
        window.label("text_" + gs.getString(GUIStrings.SOCIALID)).requireText(socialID);
    }

    @Override
    public void assertAddress(String street, String zipcode, String city) {
        window.label("text_" + gs.getString(GUIStrings.STREET)).requireText(street);
        window.label("text_" + gs.getString(GUIStrings.ZIPCODE)).requireText(zipcode);
        window.label("text_" + gs.getString(GUIStrings.CITY)).requireText(city);
    }

    @Override
    public void assertPhoneNumber(String phoneNumber) {
        window.label("text_" + gs.getString(GUIStrings.PHONE)).requireText(phoneNumber);
    }

    @Override
    public void assertCellPhoneNumber(String cellPhoneNumber) {
        window.label("text_" + gs.getString(GUIStrings.CELLPHONE)).requireText(cellPhoneNumber);
    }

    @Override
    public void assertEmail(String email) {
        window.label("text_" + gs.getString(GUIStrings.EMAIL)).requireText(email);
    }

    @Override
    public void assertPasswords(String password) {
        window.label("text_" + gs.getString(GUIStrings.PASSWORD)).requireText(password);
        window.label("text_" + gs.getString(GUIStrings.PASSWORDREPEAT)).requireText(password);
    }

    @Override
    public void login(String socialID, String password) {
        window.textBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText(socialID);
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORD)).setText(password);
    }
}
