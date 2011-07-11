package com.sigma.qsab.glitches;

import com.sigma.qsab.verifiers.RegisterVerifier;

public class FunctionGlitchManager extends GlitchManager {

    public FunctionGlitchManager() {
        super();       
    }

    public boolean isSocialIDCorrect(String text) {
        Glitch glitch = getGlitch(Glitch.SOCIALIDGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return (Boolean)glitch.performGlitch(text);
        }
        return RegisterVerifier.isSocialIDCorrect(text);
    }
    
}
