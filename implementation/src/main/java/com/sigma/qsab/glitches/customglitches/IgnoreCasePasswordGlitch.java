package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;

public class IgnoreCasePasswordGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte versaler och gemener i l\u00f6senord";
    private static String longDesc = "Kontrollerar att l\u00f6senord \u00f6verensst\u00e4mmer vid "
            + "registrering, men g\u00f6r inte skillnad p\u00e5 versaler och gemener.";

    public IgnoreCasePasswordGlitch() {
        super(shortDesc, longDesc, REGISTER_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        String password = (String)args[0];
        String passwordRepeat = (String)args[1];
        return password.equalsIgnoreCase(passwordRepeat);
    }
}