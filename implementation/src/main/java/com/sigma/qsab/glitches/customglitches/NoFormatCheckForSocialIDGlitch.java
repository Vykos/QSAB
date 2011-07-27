package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class NoFormatCheckForSocialIDGlitch extends Glitch {

    private static String shortDesc = "Formateringsfel i personnummer";
    private static String longDesc = "Kollar inte om personnummersstr�ngen "
            + "�r r�tt formaterad n�r man registrerar en ny kund, men kollar "
            + "fortfarande att str�ngen �r r�tt enl. Luhns algoritm.";

    public NoFormatCheckForSocialIDGlitch() {
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
