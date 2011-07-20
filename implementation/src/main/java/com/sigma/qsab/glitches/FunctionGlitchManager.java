package com.sigma.qsab.glitches;

import com.sigma.qsab.gui.RegisterComponent;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class FunctionGlitchManager extends GlitchManager {

    public FunctionGlitchManager() {
        super();
    }

    public boolean isSocialIDCorrect(String text) {
        Glitch glitch = getGlitch(Glitch.REGISTER_SOCIALIDGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return (Boolean) glitch.performGlitch(text);
        }
        return RegisterVerifier.isSocialIDCorrect(text);
    }

    public boolean isMandatoryRegisterFieldFilledOut(String text) {
        Glitch glitch = getGlitch(Glitch.REGISTER_ISMANDATORYGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return (Boolean) glitch.performGlitch(text);
        }
        return RegisterVerifier.isMandatoryRegisterFieldFilledOut(text);
    }
}
