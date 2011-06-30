package com.sigma.qsab.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GUIStrings {
    public final static int LOGIN = 0;
    public final static int REGISTER = 1;
    public final static int FIRSTNAME = 2;
    public final static int LASTNAME = 3;
    public final static int SOCIALID = 4;
    public final static int STREET = 5;
    public final static int ZIPCODE = 6;
    public final static int CITY = 7;
    public final static int PHONE = 8;
    public final static int CELLPHONE = 9;
    public final static int EMAIL = 10;
    public final static int PASSWORD = 11;
    public final static int PASSWORDREPEAT = 12;
    public final static int NEXT = 13;
    public final static int PREVIOUS = 14;
    
    private String[] strings = new String[15];
    
    public GUIStrings(String path) throws Exception {     
        File f = new File(getClass().getResource(path).toString().substring(6));        
        BufferedReader fr = new BufferedReader(new FileReader(f));
        String tmp;                        
        String[] line;    
        /* Bör kanske inte vara en loop utan skrivas så den läser in saker rätt
         * oavsett ordning. */
        for (int i = 0; (tmp = fr.readLine()) != null && i<strings.length;) {
            if (tmp.replaceAll(" ", "").equals("")) continue;
            if (tmp.substring(0,2).equals("//")) continue;                        
            line = tmp.split("::");
            strings[i] = line[1];
            i++;
        }
    }
    
    public String getString(int key) {
        if ((key < 0) || (key > strings.length-1)) return "ERROR";
        if (strings[key] == null) return "ERROR";
        return strings[key];
    }
}
