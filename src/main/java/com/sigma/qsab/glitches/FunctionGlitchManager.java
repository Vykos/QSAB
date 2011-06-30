package com.sigma.qsab.glitches;

import com.sigma.qsab.glitches.customglitches.SocialIDGlitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class FunctionGlitchManager extends GlitchManager {

    public FunctionGlitchManager() {
        super();
        if (USESOCIALIDGLITCH) {
            this.putGlitch(new SocialIDGlitch("Formateringsfel i pnr",
                    "Kollar inte om personnummerssträngen är rätt formaterad " +
                    "när man registrerar en ny kund"));
        }
    }

    public boolean isSocialIDCorrect(String text) {
        Glitch glitch = getGlitch(Glitch.SOCIALIDGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return glitch.isSocialIDCorrect(text);
        }
        return RegisterVerifier.isSocialIDCorrect(text);
    }
    
}
