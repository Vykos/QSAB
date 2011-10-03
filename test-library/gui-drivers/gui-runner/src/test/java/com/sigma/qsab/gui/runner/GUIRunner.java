package com.sigma.qsab.gui.runner;

public interface GUIRunner {

    public void initiateGUIRunner();

    public void tearDownGUIRunner();    

    public void clickButton(String buttonText);

    public void selectItemFromGlitchList(String item);

    public void fillInName(String firstname, String lastname);

    public void fillInSocialID(String socialID);

    public void fillInAddress(String street, String zipcode, String city);

    public void fillInPhoneNumber(String phoneNumber);

    public void fillInCellPhoneNumber(String cellPhoneNumber);

    public void fillInEmail(String email);

    public void fillInPasswordTwice(String password);

    public void assertName(String firstname, String lastname);

    public void assertSocialID(String socialID);

    public void assertAddress(String street, String zipcode, String city);

    public void assertPhoneNumber(String phoneNumber);

    public void assertCellPhoneNumber(String cellPhoneNumber);

    public void assertEmail(String email);

    public void assertPasswords(String password);

    public void login(String socialID, String password);        
        
    public void pause(long timeToSleep);
}
