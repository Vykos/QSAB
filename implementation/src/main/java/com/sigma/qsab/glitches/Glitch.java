package com.sigma.qsab.glitches;

import com.sigma.qsab.gui.RegisterComponent;

public abstract class Glitch implements Comparable<Glitch> {
    public static int FUNCTIONMIN = 1000;
    public static int SOCIALIDGLITCH = 1001;
    public static int REGISTERVERIFYGLITCH = 1002;
    public static int FUNCTIONMAX = 1999;

    public static int GUIMIN = 2000;
    public static int TEXTFIELDGLITCH = 2001;
    public static int PASSWORDFIELDGLITCH = 2002;
    public static int GUIMAX = 2999;

    private String longDescription, shortDescription;
    private int overrideID;

    protected Glitch(String longDescription, String shortDescription) {
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
    }

    protected Glitch(String shortDescription, String longDescription, int overrideID) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.overrideID = overrideID;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getOverrideID() {
        return overrideID;
    }

    public void setOverrideID(int overrideID) {
        this.overrideID = overrideID;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /* Glitches, override the one you need or things will break. */
    public boolean isSocialIDCorrect(String socialID) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public RegisterComponent makeTextRegisterComponent(String text,
                                                       boolean mandatory, int componentNR) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public RegisterComponent makePasswordRegisterComponent(String text, boolean mandatory, int componentNR) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int compareTo(Glitch o) {
        return shortDescription.compareTo(o.getShortDescription());
    }
}
