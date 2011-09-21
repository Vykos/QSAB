package com.sigma.qsab.glitches.customglitches.login;



import com.sigma.qsab.glitches.Glitch;

public class IgnoreCaseForComparingPasswordsGlitch extends Glitch {

    private static String shortDesc = "Kontrollera inte versaler och gemener i lösenord vid login";
    private static String longDesc = "Kontrollerar att lösenord överensstämmer vid "
            + "login, men gör inte skillnad på versaler och gemener.";

    public IgnoreCaseForComparingPasswordsGlitch() {
        super(shortDesc, longDesc, REGISTER_AREPASSWORDSEQUALGLITCH);
    }

    @Override
    public Object performGlitch(Object... args) {
        String password = (String)args[0];
        String passwordRepeat = (String)args[1];
        return password.equalsIgnoreCase(passwordRepeat);
    }
}