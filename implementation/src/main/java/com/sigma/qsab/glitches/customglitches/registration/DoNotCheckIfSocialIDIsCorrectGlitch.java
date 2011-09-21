package com.sigma.qsab.glitches.customglitches.registration;

import com.sigma.qsab.glitches.Glitch;

public class DoNotCheckIfSocialIDIsCorrectGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte personnummer alls";
    private static String longDesc = "Kontrollerar inte huruvida personnummer "
            + "är ifyllt över huvud taget. Är fältet betvingat så kan det "
            + "fortfarande gälla att blanka strängar inte går igenom, beroende "
            + "på val av andra fel.";

    public DoNotCheckIfSocialIDIsCorrectGlitch() {
        super(shortDesc, longDesc, REGISTER_SOCIALIDGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}
