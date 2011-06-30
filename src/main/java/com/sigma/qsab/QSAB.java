package com.sigma.qsab;

import com.sigma.qsab.glitches.GlitchManagersSingleton;
import com.sigma.qsab.gui.*;

public class QSAB
{
    private MainFrame mainFrame;
    private GlitchManagersSingleton glitchManagersSingleton;
    
    public static void main( String[] args ) {
        new QSAB();
    }
    
    public QSAB() {        
        glitchManagersSingleton = GlitchManagersSingleton.getInstance();
        mainFrame = new MainFrame("Quality Spa AB");        
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }    
    
}
