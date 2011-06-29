package com.sigma.qsab;

import com.sigma.qsab.gui.*;

/**
 * Hello world!
 *
 */
public class QSAB
{
    MainFrame mainFrame;
    public static void main( String[] args ) {
        new QSAB();
    }
    
    public QSAB() {
        mainFrame = new MainFrame("Quality Spa AB");
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
