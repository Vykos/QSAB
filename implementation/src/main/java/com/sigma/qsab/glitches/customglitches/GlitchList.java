package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import java.util.Arrays;

public abstract class GlitchList {

    public static Glitch[] getAllGlitches() {
        Glitch[] glitchArray = new Glitch[]{
            new PasswordFieldGlitch(),
            new SocialIDGlitch()
        };

        Arrays.sort(glitchArray);
        return glitchArray;
    }
}
