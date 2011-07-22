package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class IsMandatoryGlitch extends Glitch {
    private static String shortDesc = "Kollar inte om fält måste vara ifyllda";
    private static String longDesc = "Kontrollerar inte om stjärnmärkta fält " +
            "i registreringspanelen är ifyllda, utan släpper igenom tomma fält.";

    public IsMandatoryGlitch() {
        super(shortDesc, longDesc, REGISTER_ISMANDATORYGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
    
    
}
