package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class DoNotComparePasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte om l�senord �verensst�mmer";
    private static String longDesc = "Kontrollerar inte om l�senordet som "
            + "upprepats �verensst�mmer med det l�senord som fyllts i l�senords"
            + "f�ltet.";

    public DoNotComparePasswordsGlitch() {
        super(shortDesc, longDesc, REGISTER_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
}