/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui;

import org.fest.swing.fixture.FrameFixture;

/**
 *
 * @author ext.jonas.frogvall
 */
public class RegisterLibrary {
    
    private GUIStrings gs;
    private FrameFixture window;
    
    public RegisterLibrary (FrameFixture window){
        this.window = window;
        try {
            gs = new GUIStrings("/strings.properties");
        } catch (Exception e) {}        
    }
    
    public void clickButton(String buttonName) {
        window.button(buttonName).click();
    }
    
    public void fillInName(String firstname, String lastname) {
        window.textBox("field_" + gs.getString(GUIStrings.FIRSTNAME)).setText(firstname);
        window.textBox("field_" + gs.getString(GUIStrings.LASTNAME)).setText(lastname);
    }
    
    public void fillInSocialID(String socialID) {
        window.textBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText(socialID);
    }    
    
    public void fillInAddress(String street, String zipcode, String city) {
        window.textBox("field_" + gs.getString(GUIStrings.STREET)).setText(street);
        window.textBox("field_" + gs.getString(GUIStrings.ZIPCODE)).setText(zipcode);
        window.textBox("field_" + gs.getString(GUIStrings.CITY)).setText(city);
    }
    
    public void fillInPhoneNumber(String phoneNumber) {
        window.textBox("field_" + gs.getString(GUIStrings.PHONE)).setText(phoneNumber);
    }
    
    public void fillInCellPhoneNumber(String cellPhoneNumber) {
        window.textBox("field_" + gs.getString(GUIStrings.CELLPHONE)).setText(cellPhoneNumber);
    }
    
    public void fillInEmail(String email) {
        window.textBox("field_" + gs.getString(GUIStrings.EMAIL)).setText(email);
    }
    
    public void fillInPasswordTwice(String password) {
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORD)).setText(password);
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORDREPEAT)).setText(password);
    }            
    
    public void assertName(String firstname, String lastname) {
        window.label("text_" + gs.getString(GUIStrings.FIRSTNAME)).requireText(firstname);
        window.label("text_" + gs.getString(GUIStrings.LASTNAME)).requireText(lastname);
    }
    
    public void assertSocialID(String socialID) {
        window.label("text_" + gs.getString(GUIStrings.SOCIALID)).requireText(socialID);
    }
    
    public void assertAddress(String street, String zipcode, String city) {
        window.label("text_" + gs.getString(GUIStrings.STREET)).requireText(street);
        window.label("text_" + gs.getString(GUIStrings.ZIPCODE)).requireText(zipcode);
        window.label("text_" + gs.getString(GUIStrings.CITY)).requireText(city);        
    }
    
    public void assertPhoneNumber(String phoneNumber) {
        window.label("text_" + gs.getString(GUIStrings.PHONE)).requireText(phoneNumber);
    }
    
    public void assertCellPhoneNumber(String cellPhoneNumber) {
        window.label("text_" + gs.getString(GUIStrings.CELLPHONE)).requireText(cellPhoneNumber);
    }
    
    public void assertEmail(String email) {
        window.label("text_" + gs.getString(GUIStrings.EMAIL)).requireText(email);
    }
    
    public void assertPasswords(String password) {
        window.label("text_" + gs.getString(GUIStrings.PASSWORD)).requireText(password);
        window.label("text_" + gs.getString(GUIStrings.PASSWORDREPEAT)).requireText(password);      
    }   
}
