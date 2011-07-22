package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class NoCheckForSocialIDGlitch extends Glitch {
    private static String shortDesc = "Kontrollera inte personnummer alls";
    private static String longDesc = "Kontrollerar inte huruvida personnummer " +
            "är ifyllt över huvud taget. är fältet betvingat så kan det " +
            "fortfarande gälla att blanka strängar inte går igenom, beroende " +
            "på val av andra fel.";

    public NoCheckForSocialIDGlitch() {
        super(shortDesc, longDesc, REGISTER_SOCIALIDGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
    
    
}
