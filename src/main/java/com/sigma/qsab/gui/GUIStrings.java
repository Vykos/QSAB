package com.sigma.qsab.gui;

import java.util.Properties;

public class GUIStrings {
    public final static String LOGIN = "login";
    public final static String REGISTER = "register";
    public final static String FIRSTNAME = "firstname";
    public final static String LASTNAME = "lastname";
    public final static String SOCIALID = "socialid";
    public final static String STREET = "street";
    public final static String ZIPCODE = "zipcode";
    public final static String CITY = "city";
    public final static String PHONE = "phone";
    public final static String CELLPHONE = "cellphone";
    public final static String EMAIL = "email";
    public final static String PASSWORD = "password";
    public final static String PASSWORDREPEAT = "passwordrepeat";
    public final static String NEXT = "next";
    public final static String PREVIOUS = "previous";
    public final static String SUPERADMINACCEPT="superadminaccept";
        
    private Properties strings;
    
    public GUIStrings(String path) throws Exception {   
        strings = new Properties();     
        strings.load(getClass().getResourceAsStream(path));        
    }
    
    public String getString(String key) {        
        return strings.getProperty(key, "ERROR");
    }
}
