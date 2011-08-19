
package com.sigma.qsab.verifiers;

public class LoginVerifier {

    public static boolean arePasswordsEqual(String attemptedPassword, String storedPassword) {
        //Should maybe take encryption into consideration
        return attemptedPassword.equals(storedPassword);
    }
    
}
