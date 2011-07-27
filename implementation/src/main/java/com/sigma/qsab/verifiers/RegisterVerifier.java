/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.verifiers;

import com.sigma.qsab.gui.RegisterComponent;

public class RegisterVerifier {

    private final static int expectedSocialIDLength = 11;
    private final static int expectedSocialIDDashIndex = 6;

    public static boolean isSocialIDCorrect(String socialID) {
        if (socialID.length() != expectedSocialIDLength) {
            return false;
        }
        for (int i = 0; i < expectedSocialIDLength; i++) {
            char c = socialID.charAt(i);
            if (i == expectedSocialIDDashIndex) {
                if (!correctDashCharacter(c)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        String tmpSocialID = socialID.replaceAll("-", "").replaceAll("\\+", "");
        return isCorrectSocialIDAccordingToLuhn(tmpSocialID);
    }

    private static boolean correctDashCharacter(char c) {
        return (((c == '-') || (c == '+')));
    }

    public static boolean isCorrectSocialIDAccordingToLuhn(String indata) {
        int checknum = 1;
        int sum = 0;
        int term;
        for (int i = indata.length() - 1; i >= 0; i--) {
            term = Character.digit(indata.charAt(i), 10) * checknum;
            if (term > 9) {
                term -= 9;
            }
            sum += term;
            checknum = 3 - checknum;
        }
        return (sum % 10) == 0;
    }

    public static boolean isMandatoryRegisterFieldFilledOut(String text) {
        return !(text.replaceAll(" ", "").equals(""));
    }

    public static boolean arePasswordsEqual(String password, String passwordrepeat) {
        return password.equals(passwordrepeat);
    }
}
