package com.sigma.qsab.glitches;

import com.sigma.qsab.glitches.customglitches.PasswordFieldGlitch;
import com.sigma.qsab.gui.ComponentMaker;
import com.sigma.qsab.gui.RegisterComponent;

public class GUIGlitchManager extends GlitchManager {

    public GUIGlitchManager() {
        super();
        if (USEPASSWORDFIELDGLITCH) {
            this.putGlitch(new PasswordFieldGlitch("Visa lösenord öppet",
                    "Döljer inte inskrivna lösenord med *"));
        }
    }

    public RegisterComponent makeTextRegisterComponent(String text, 
            boolean mandatory, int componentNR) {
        Glitch glitch = getGlitch(Glitch.TEXTFIELDGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return glitch.makeTextRegisterComponent(text, mandatory, 
                componentNR); 
        }
        return ComponentMaker.makeTextRegisterComponent(text, mandatory, 
                componentNR);        
    }     
    
    public RegisterComponent makePasswordRegisterComponent(String text, 
            boolean mandatory, int componentNR) {
        Glitch glitch = getGlitch(Glitch.PASSWORDFIELDGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return glitch.makePasswordRegisterComponent(text, mandatory, 
                componentNR); 
        }
        return ComponentMaker.makePasswordRegisterComponent(text, mandatory, 
                componentNR);        
    } 
    
}
