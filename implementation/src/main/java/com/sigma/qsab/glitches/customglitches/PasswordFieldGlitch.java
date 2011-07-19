package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.gui.ComponentMaker;

public class PasswordFieldGlitch extends Glitch {

    private static String shortDesc = "Visa l�senord �ppet";
    private static String longDesc = "D�ljer inte inskrivna l�senord med *";

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
