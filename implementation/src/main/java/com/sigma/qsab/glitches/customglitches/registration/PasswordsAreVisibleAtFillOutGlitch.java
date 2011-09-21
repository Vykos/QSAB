package com.sigma.qsab.glitches.customglitches.registration;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.gui.ComponentMaker;

public class PasswordsAreVisibleAtFillOutGlitch extends Glitch {

    private static String shortDesc = "Visa lösenord öppet";
    private static String longDesc = "Döljer inte inskrivna lösenord i "
            + "registreringspanelen med *";

    public PasswordsAreVisibleAtFillOutGlitch() {
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
