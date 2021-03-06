package com.sigma.qsab.gui;

import java.io.IOException;
import java.util.Properties;

public class GUIStrings {
    public final static String LOGIN                = "login";
    public final static String LOGOUT               = "logout";
    public final static String CANCEL               = "cancel";
    public final static String REGISTER             = "register";
    public final static String FIRSTNAME            = "firstname";
    public final static String LASTNAME             = "lastname";
    public final static String SOCIALID             = "socialid";
    public final static String STREET               = "street";
    public final static String ZIPCODE              = "zipcode";
    public final static String CITY                 = "city";
    public final static String PHONE                = "phone";
    public final static String CELLPHONE            = "cellphone";
    public final static String EMAIL                = "email";
    public final static String PASSWORD             = "password";
    public final static String PASSWORDREPEAT       = "passwordrepeat";
    public final static String NEXT                 = "next";
    public final static String PREVIOUS             = "previous";
    public final static String SUPERADMINACCEPT     = "superadminaccept";
    public final static String CHOOSEGLITCHES       = "chooseglitches";
    public final static String REGISTERERRORMESSAGE = "registererrormessage";
    public final static String LOGINERRORMESSAGE    = "loginerrormessage";
    public final static String USERALREADYEXISTS    = "useralreadyexists";
    
        
    private Properties strings;
    
    public GUIStrings(String path) throws IOException {
        strings = new Properties();     
        strings.load(getClass().getResourceAsStream(path));        
    }
    
    public String getString(String key) {        
        return strings.getProperty(key, "ERROR");
    }
}
