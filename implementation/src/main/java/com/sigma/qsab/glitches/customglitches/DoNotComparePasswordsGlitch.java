package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class DoNotComparePasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte om lösenord överensstämmer";
    private static String longDesc = "Kontrollerar inte om lösenordet som "
            + "upprepats överensstämmer med det lösenord som fyllts i lösenords"
            + "fältet.";

    public DoNotComparePasswordsGlitch() {
        super(shortDesc, longDesc, REGISTER_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}