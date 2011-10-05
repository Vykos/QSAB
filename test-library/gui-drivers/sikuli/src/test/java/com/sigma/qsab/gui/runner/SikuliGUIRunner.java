package com.sigma.qsab.gui.runner;

import com.sigma.qsab.QSAB;
import com.sigma.qsab.gui.MainFrame;
import java.net.URL;
import junit.framework.Assert;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;

public class SikuliGUIRunner implements GUIRunner {

    private static final double minimumSimilarityScore = 0.98;
    private static final boolean showActions = false;
    private Screen screen;
    private MainFrame mainFrame;

    public SikuliGUIRunner() {
        //do nothing
    }

    @Override
    public void assertAddress(String street, String zipcode, String city) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertCellPhoneNumber(String cellPhoneNumber) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertEmail(String email) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertName(String firstName, String lastName) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertPasswords(String password) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertPhoneNumber(String phoneNumber) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertSocialID(String socialID) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clickButton(String buttonText) {
        if (successfullyClickedButton(buttonText)) {
            return;
        }
        if (successfullyClickedButton(buttonText + " focused")) {
            return;
        }
        if (successfullyClickedButton(buttonText + " mouseover")) {
            return;
        }
        if (successfullyClickedButton(buttonText + " focused mouseover")) {
            return;
        }
        //Nothing found, probably should do something.
    }

    @Override
    public void fillInAddress(String street, String zipcode, String city) {
        try {
            screen.type(fullPath("Postadress"), street, 0);
            screen.type(fullPath("Postnummer"), zipcode, 0);
            screen.type(fullPath("Ort"), city, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInCellPhoneNumber(String cellPhoneNumber) {
        try {
            screen.type(fullPath("Mobil"), cellPhoneNumber, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInEmail(String email) {
        try {
            screen.paste(fullPath("E-postadress"), email);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInName(String firstName, String lastName) {
        try {
            screen.type(fullPath("Förnamn"), firstName, 0);
            screen.type(fullPath("Efternamn"), lastName, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInPasswordTwice(String password) {
        try {
            screen.type(fullPath("Lösenord"), password, 0);
            screen.type(fullPath("Upprepa lösenord"), password, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInPhoneNumber(String phoneNumber) {
        try {
            screen.type(fullPath("Hemtelefon"), phoneNumber, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void fillInSocialID(String socialID) {
        try {
            screen.type(fullPath("Personnummer"), socialID, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void initiateGUIRunner() {
        mainFrame = new QSAB().getMainFrame();
        screen = new Screen();
        Settings.MinSimilarity = minimumSimilarityScore;
        Settings.ShowActions = showActions;
    }

    @Override
    public void login(String socialID, String password) {
        try {
            screen.type(fullPath("Login Personnummer"), socialID, 0);
            screen.type(fullPath("Login Lösenord"), password, 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void selectItemFromGlitchList(String item) {
        try {
            screen.click(fullPath(item), 0);
        } catch (FindFailed ff) {
            //Do nothing.
        }
    }

    @Override
    public void tearDownGUIRunner() {
        mainFrame.dispose();
    }

    private String fullPath(final String text) {
        String fileName = text + ".png";
        final URL url = ClassLoader.getSystemResource(fileName);
        return url.toExternalForm();//.getPath();
    }

    private boolean successfullyClickedButton(String buttonFileName) {
        try {
            screen.click(fullPath(buttonFileName), 0);
            return true;
        } catch (FindFailed ff) {
            return false;
        }
    }

    @Override
    public void assertLoggedIn() {
        Assert.assertTrue("Customer did not get logged in.", buttonExists("Logga ut"));
    }

    @SuppressWarnings("CallToThreadDumpStack")
    @Override
    public void pause(long timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean buttonExists(String buttonText) {
        Match match;
        match = screen.exists(fullPath(buttonText));
        if (match == null) {
            match = screen.exists(fullPath(buttonText + " focused"));
        }
        if (match == null) {
            match = screen.exists(fullPath(buttonText + " mouseover"));
        }
        if (match == null) {
            match = screen.exists(fullPath(buttonText + " focused mouseover"));
        }
        return (match == null ? false : true);
    }
}
