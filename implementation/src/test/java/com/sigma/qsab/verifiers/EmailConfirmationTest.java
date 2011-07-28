package com.sigma.qsab.verifiers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EmailConfirmationTest {

    @Test
    public void verifyCorrectEmail() {
        String sample = "test@test.com";
        boolean expected = true;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmail() {
        String sample = "notanemailaddress";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithAt() {
        String sample = "notanemailaddress@either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithAtAndDot() {
        String sample = "not.anemailaddress@either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithDoubleDots() {
        String sample = "not..anemail@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithMoreThanOneAt() {
        String sample = "not@anemail@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithUnallowedLocalChar() {
        String sample = "not¤anemail@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithAnotherUnallowedLocalChar() {
        String sample = "not;anemail@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyCorrectEmailsWithAllSpecialChars() {
        String sample1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "@test.com";
        String sample2 = "0123456789.!#$%&'*+-/=?^_`{|}~@test.com";
        boolean expected = true;

        boolean actual = RegisterVerifier.isEmailCorrect(sample1);

        assertThat(actual, is(expected));
        
        actual = RegisterVerifier.isEmailCorrect(sample2);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithUnallowedCharAsLastLocalChar() {
        String sample = "notanemail;@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithDotAtStart() {
        String sample = ".notanemail@address.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithDotAtEnd() {
        String sample = "notanemail@address.either.";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithAtAtStart() {
        String sample = "@notanemailaddress.either";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithAtAtEnd() {
        String sample = "notanemailaddress.either@";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test    
    public void verifyIncorrectEmailLongerThan254Chars() {
        String sample = "local@";
        while (sample.length() < 251) {
            sample += "x";
        }
        sample +=".com";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test    
    public void verifyIncorrectEmailLocalPartLongerThan64Chars() {
        String sample = "";
        while (sample.length() < 65) {
            sample += "x";
        }
        sample +="@test.com";
        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyCorrectEmailIllegalCharsUsingQuotedStrings() {
        String sample = "\"<(o o<) (>o o)>\"@test.com";
        
        boolean expected = true;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test    
    public void verifyIncorrectEmailWithOneQuotationMark() {
        String sample = "\"test@test.com";

        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test    
    public void verifyIncorrectEmailWithThreeQuotationMark() {
        String sample = "\"test\"test\"@test.com";

        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test    
    public void verifyIncorrectEmailWithQuotationStringsNotAtStart() {
        String sample = "test\"test\"@test.com";

        boolean expected = false;

        boolean actual = RegisterVerifier.isEmailCorrect(sample);

        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithQuotationStringsInDomain() {
        String sample = "test@\"test.com\"";
        
        boolean expected = false;
        
        boolean actual = RegisterVerifier.isEmailCorrect(sample);
        
        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithLabelOver63CharsLong() {
        String sample = "local@";
                
        while (sample.length() < 70) {
            sample += "x";
        }
        sample +=".com";
        
        boolean expected = false;
        
        boolean actual = RegisterVerifier.isEmailCorrect(sample);
        
        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithDoubleDotInDomain() {
        String sample = "test@test..com";
        
        boolean expected = false;
        
        boolean actual = RegisterVerifier.isEmailCorrect(sample);
        
        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithHyphenInLabelStart() {
        String sample = "test@test.-test.com";
        
        boolean expected = false;
        
        boolean actual = RegisterVerifier.isEmailCorrect(sample);
        
        assertThat(actual, is(expected));
    }
    
    @Test
    public void verifyIncorrectEmailWithHyphenInLabelEnd() {
        String sample = "test@test.test-.com";
        
        boolean expected = false;
        
        boolean actual = RegisterVerifier.isEmailCorrect(sample);
        
        assertThat(actual, is(expected));
    }
}
