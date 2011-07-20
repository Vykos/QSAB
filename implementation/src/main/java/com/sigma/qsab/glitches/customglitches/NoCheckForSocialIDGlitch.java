package com.sigma.qsab.glitches.customglitches;

import com.sigma.qsab.glitches.Glitch;
import com.sigma.qsab.verifiers.RegisterVerifier;

public class NoCheckForSocialIDGlitch extends Glitch {
    private static String shortDesc = "Kontrollera inte personnummer alls";
    private static String longDesc = "Kontrollerar inte huruvida personnummer " +
            "�r ifyllt �ver huvud taget. �r f�ltet betvingat s� kan det " +
            "fortfarande g�lla att blanka str�ngar inte g�r igenom, beroende " +
            "p� val av andra fel.";    

    public NoCheckForSocialIDGlitch() {
        super(shortDesc, longDesc, REGISTER_SOCIALIDGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        return true;
    }
    
    
}
