
package com.sigma.qsab.verifiers;

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

    public static boolean isEmailCorrect(String emailAddress) {
        String email = emailAddress;
        if (email.length() > 254) return false;
        if (email.lastIndexOf("@") > 64) return false;
        if (email.charAt(0) == '.') return false;
        if (email.charAt(0) == '@') return false;
        if (email.charAt(0) == '"') {
            String[] tmp = email.split("\"");
            if (tmp.length != 3) return false;
            email = tmp[2];
        }
        if (!email.contains("@")) return false;
        if (email.charAt(email.length()-1) == '.') return false;        
        if (email.indexOf("@") != email.lastIndexOf("@")) return false;        
        if (email.lastIndexOf(".") < email.lastIndexOf("@")) return false;               
        for (int i = 0; i < email.indexOf("@"); i++) {            
            char c = email.charAt(i);
            if (!isCharAllowedForLocalPartOfEmail(c)) return false;
            if (c == '.') {
                char c2 = email.charAt(i+1);
                if (c2 == '.') return false;
            }
        }
        for (int i = email.indexOf("@")+1; i < email.length(); i++) {            
            char c = email.charAt(i);
            if (!isCharAllowedForDomainPartOfEmail(c)) return false;
        }
        
        String domain = email.substring(email.indexOf("@")+1);        
        String[] labels = domain.split("\\.");
        for (String label : labels) {
            if (label.length() > 63) return false;
            if (label.length() < 1) return false;
            if (label.startsWith("-")) return false;
            if (label.endsWith("-")) return false;
        }
        return true;
    }

    private static boolean isCharAllowedForLocalPartOfEmail(char c) {
        if (isCharBetween(c, 'a', 'z')) return true;
        if (isCharBetween(c, 'A', 'Z')) return true;
        if (isCharBetween(c, '0', '9')) return true;
        if (isCharASpecialCharacterAllowedInLocalPartOfEmail(c)) return true;
        return false;
    }
    
    private static boolean isCharAllowedForDomainPartOfEmail(char c) {
        if (isCharBetween(c, 'a', 'z')) return true;
        if (isCharBetween(c, 'A', 'Z')) return true;
        if (isCharBetween(c, '0', '9')) return true;
        if (isCharASpecialCharacterAllowedInDomainPartOfEmail(c)) return true;
        return false;
    }
    
    private static boolean isCharASpecialCharacterAllowedInLocalPartOfEmail(char c) {
        char[] chars = {'!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=',
            '?', '^', '_', '`', '{', '|', '}', '~', '.'};
        for (char ch : chars) {
            if (c == ch) return true;
        }
        return false;
    }
    
    private static boolean isCharASpecialCharacterAllowedInDomainPartOfEmail(char c) {
        char[] chars = {'-', '.'};
        for (char ch : chars) {
            if (c == ch) return true;
        }
        return false;
    }
    
    private static boolean isCharBetween(char c, char a, char b) {
        return ((c >= a) && c <= b);
    }  
}
