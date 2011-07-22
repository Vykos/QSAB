package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.gui.ComponentMaker;

public class PasswordFieldGlitch extends Glitch {

    private static String shortDesc = "Visa lösenord öppet";
    private static String longDesc = "Döljer inte inskrivna lösenord med *";

    public PasswordFieldGlitch() {
        super(shortDesc, longDesc, PASSWORDFIELDGLITCH);
    }
    
    @Override
    public Object performGlitch(Object... args) {
        String text = (String) args[0];
        boolean mandatory = (Boolean) args[1];
        int componentNR = (Integer) args[2];

        return ComponentMaker.makeTextRegisterComponent(
                text, mandatory, componentNR);
    }
}
