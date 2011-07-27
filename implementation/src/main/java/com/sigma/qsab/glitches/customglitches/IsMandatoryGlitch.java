package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;

public class IsMandatoryGlitch extends Glitch {

    private static String shortDesc = "Kollar inte om f�lt m�ste vara ifyllda";
    private static String longDesc = "Kontrollerar inte om stj�rnm�rkta f�lt "
            + "i registreringspanelen �r ifyllda, utan sl�pper igenom tomma f�lt.";

    public IsMandatoryGlitch() {
        super(shortDesc, longDesc, REGISTER_ISMANDATORYGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}
