package com.sigma.qsab.glitches.customglitches.registration;

import com.sigma.qsab.glitches.Glitch;

public class DoNotComparePasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte om l\u00f6senord \u00f6verensst\u00e4mmer vid registrering";
    private static String longDesc = "Kontrollerar inte om l\u00f6senordet som "
            + "upprepats \u00f6verensst\u00e4mmer med det l\u00f6senord som fyllts i l\u00f6senords"
            + "f\u00e4ltet.";

    public DoNotComparePasswordsGlitch() {
        super(shortDesc, longDesc, REGISTER_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}