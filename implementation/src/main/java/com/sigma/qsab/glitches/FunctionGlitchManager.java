package com.sigma.qsab.glitches;

import com.sigma.qsab.verifiers.LoginVerifier;
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

    public boolean arePasswordsEqual(String password, String passwordrepeat) {
        Glitch glitch = getGlitch(Glitch.REGISTER_AREPASSWORDSEQUALGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return (Boolean) glitch.performGlitch(password, passwordrepeat);
        }
        return RegisterVerifier.arePasswordsEqual(password, passwordrepeat);
    }

    public boolean compareLoginPasswords(String attemptedPassword, String storedPassword) {
        Glitch glitch = getGlitch(Glitch.LOGIN_AREPASSWORDSEQUALGLITCH);
        if (glitchExists(glitch)) {
            //use glitch version
            return (Boolean) glitch.performGlitch(attemptedPassword, storedPassword);
        }
        return LoginVerifier.arePasswordsEqual(attemptedPassword, storedPassword);
    }
}
