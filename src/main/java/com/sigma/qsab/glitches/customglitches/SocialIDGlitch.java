package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class SocialIDGlitch extends Glitch {

    public SocialIDGlitch(String longDescription, String shortDescription) {
        super(longDescription, shortDescription, Glitch.SOCIALIDGLITCH);
    }

    @Override
    public boolean isSocialIDCorrect(String socialID) {
        // Don't check format on the string
        String tmpSocialID = socialID.replaceAll("-", "").replaceAll("\\+", "");
        return RegisterVerifier.isCorrectSocialIDAccordingToLuhn(tmpSocialID);
    }       
}
