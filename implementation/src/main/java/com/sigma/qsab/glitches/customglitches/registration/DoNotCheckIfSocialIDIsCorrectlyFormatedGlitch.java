package com.sigma.qsab.glitches.customglitches.registration;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class DoNotCheckIfSocialIDIsCorrectlyFormatedGlitch extends Glitch {

    private static String shortDesc = "Formateringsfel i personnummer";
    private static String longDesc = "Kollar inte om personnummersstr\u00e4ngen "
            + "\u00e4r r\u00e4tt formaterad n\u00e4r man registrerar en ny kund, men kollar "
            + "fortfarande att str\u00e4ngen \u00e4r r\u00e4tt enl. Luhns algoritm.";

    public DoNotCheckIfSocialIDIsCorrectlyFormatedGlitch() {
        super(shortDesc, longDesc, REGISTER_SOCIALIDGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        String socialID = (String) args[0];

        // Don't check format on the string but still cut off +/- chars.
        String tmpSocialID = socialID.replaceAll("-", "").replaceAll("\\+", "");
        return RegisterVerifier.isCorrectSocialIDAccordingToLuhn(tmpSocialID);
    }
}
