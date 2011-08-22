package com.sigma.qsab.glitches.customglitches.registration;

import com.sigma.qsab.glitches.Glitch;

public class DoNotCheckIfSocialIDIsCorrectGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte personnummer alls";
    private static String longDesc = "Kontrollerar inte huruvida personnummer "
            + "\u00e4r ifyllt \u00f6ver huvud taget. \u00c4r f\u00e4ltet betvingat s\u00e5 kan det "
            + "fortfarande g\u00e4lla att blanka str\u00e4ngar inte g\u00e5r igenom, beroende "
            + "p\u00e5 val av andra fel.";

    public DoNotCheckIfSocialIDIsCorrectGlitch() {
        super(shortDesc, longDesc, REGISTER_SOCIALIDGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}
