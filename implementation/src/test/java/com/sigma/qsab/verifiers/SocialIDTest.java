package com.sigma.qsab.verifiers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SocialIDTest {

    @Test
    public void verifyCorrectPnr() {
        String sample = "121212-1212";
        boolean expected = true;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verify100yCorrectPnr() {
        String sample = "121212+1212";
        boolean expected = true;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyIncorrectPnr() {
        String sample = "121212-1211";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifySecondIncorrectPnr() {
        String sample = "121212-1213";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyLettersInPnr() {
        String sample = "121212-16a2";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyTooShortPnr() {
        String sample = "1212-1213";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyTooLongShortPnr() {
        String sample = "12121212-1213";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyShiftedDashPnr() {
        String sample = "1212-121212";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyWrongDashSignPnr() {
        String sample = "121212*1212";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyTooManyDashesPnr() {
        String sample = "41212+-1212";
        boolean expected = false;

        boolean actual = RegisterVerifier.isSocialIDCorrect(sample);

        assertThat(actual, is(expected));
    }
}
