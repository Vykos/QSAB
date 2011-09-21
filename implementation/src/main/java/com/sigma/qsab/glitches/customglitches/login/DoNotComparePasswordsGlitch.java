package com.sigma.qsab.glitches.customglitches.login;

import com.sigma.qsab.glitches.Glitch;

public class DoNotComparePasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte om lösenord överensstämmer vid login";
    private static String longDesc = "Kontrollerar inte om lösenordet som "
            + "fyllts i överensstämmer med det lösenord som sparats undan vid registrering.";

    public DoNotComparePasswordsGlitch() {
        super(shortDesc, longDesc, LOGIN_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}