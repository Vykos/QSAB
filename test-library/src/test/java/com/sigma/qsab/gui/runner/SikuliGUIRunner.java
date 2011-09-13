package com.sigma.qsab.gui.runner;

import com.sigma.qsab.QSAB;
import com.sigma.qsab.gui.GUIStrings;
import com.sigma.qsab.gui.MainFrame;
import java.io.IOException;
import java.net.URL;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.Settings;

public class SikuliGUIRunner extends GUIRunner {    
    
    private static final double minimumSimilarityScore = 0.9;
    private static final boolean showActions = true;
    private Screen screen;
    private MainFrame mainFrame;
    private GUIStrings gs;
    
    @SuppressWarnings("CallToThreadDumpStack")
    public SikuliGUIRunner() {
        try {
            gs = new GUIStrings("/strings.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void assertName(String firstname, String lastname) {
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
    public void fillInName(String firstname, String lastname) {
        try {
            screen.type(fullPath("Förnamn"), firstname, 0);            
            screen.type(fullPath("Efternamn"), lastname, 0);
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
    public void initiate() {
        screen = new Screen();
        mainFrame = new QSAB().getMainFrame();
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
    public void tearDown() {
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
}
