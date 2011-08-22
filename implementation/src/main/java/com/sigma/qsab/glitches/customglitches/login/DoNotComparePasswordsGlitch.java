package com.sigma.qsab.glitches.customglitches.login;

import com.sigma.qsab.glitches.Glitch;

public class DoNotComparePasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte om l\u00f6senord \u00f6verensst\u00e4mmer vid login";
    private static String longDesc = "Kontrollerar inte om l\u00f6senordet som "
            + "fyllts i \u00f6verensst\u00e4mmer med det l\u00f6senord som sparats undan vid registrering.";

    public DoNotComparePasswordsGlitch() {
        super(shortDesc, longDesc, LOGIN_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}