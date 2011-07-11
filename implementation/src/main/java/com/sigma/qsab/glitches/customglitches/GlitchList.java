/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import java.util.Arrays;

/**
 *
 * @author ext.jonas.frogvall
 */
public abstract class GlitchList {
    
    public static Glitch[] getAllGlitches() {
        Glitch[] glitchArray = new Glitch[] {
            new PasswordFieldGlitch("Visa lösenord öppet",
                    "Döljer inte inskrivna lösenord med *"),
            new SocialIDGlitch("Formateringsfel i personnummer",
                    "Kollar inte om personnummerssträngen är rätt formaterad " +
                    "när man registrerar en ny kund")
        };
        
        Arrays.sort(glitchArray);
        return glitchArray;
    }
}
