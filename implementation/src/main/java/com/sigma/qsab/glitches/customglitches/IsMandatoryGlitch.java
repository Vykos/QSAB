package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;

public class IsMandatoryGlitch extends Glitch {

    private static String shortDesc = "Kollar inte om f\u00e4lt m\u00e5ste vara ifyllda";
    private static String longDesc = "Kontrollerar inte om stj\u00e4rnm\u00e4rkta f\u00e4lt "
            + "i registreringspanelen \u00e4r ifyllda, utan sl\u00e4pper igenom tomma f\u00e4lt.";

    public IsMandatoryGlitch() {
        super(shortDesc, longDesc, REGISTER_ISMANDATORYGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}
