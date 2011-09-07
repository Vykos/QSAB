package com.sigma.qsab.gui.runner;

public abstract class GUIRunner {

    public abstract void initiate();

    public abstract void tearDown();    

    public abstract void clickButton(String buttonName);

    public abstract void selectItemFromGlitchList(String item);

    public abstract void fillInName(String firstname, String lastname);

    public abstract void fillInSocialID(String socialID);

    public abstract void fillInAddress(String street, String zipcode, String city);

    public abstract void fillInPhoneNumber(String phoneNumber);

    public abstract void fillInCellPhoneNumber(String cellPhoneNumber);

    public abstract void fillInEmail(String email);

    public abstract void fillInPasswordTwice(String password);

    public abstract void assertName(String firstname, String lastname);

    public abstract void assertSocialID(String socialID);

    public abstract void assertAddress(String street, String zipcode, String city);

    public abstract void assertPhoneNumber(String phoneNumber);

    public abstract void assertCellPhoneNumber(String cellPhoneNumber);

    public abstract void assertEmail(String email);

    public abstract void assertPasswords(String password);

    public abstract void login(String socialID, String password);
    
    @SuppressWarnings("CallToThreadDumpStack")
    public void pause(long timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
