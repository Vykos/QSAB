package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.gui.ComponentMaker;
import com.sigma.qsab.gui.RegisterComponent;

public class PasswordFieldGlitch extends Glitch {

    public PasswordFieldGlitch(String longDescription, String shortDescription) {
        super(longDescription, shortDescription, Glitch.PASSWORDFIELDGLITCH);
    }

    @Override
    public RegisterComponent makePasswordRegisterComponent(String text,
            boolean mandatory, int componentNR) {
        return ComponentMaker.makeTextRegisterComponent(
                text, mandatory, componentNR);
    }
}
