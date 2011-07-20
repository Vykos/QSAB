package com.sigma.qsab.glitches;

public abstract class Glitch implements Comparable<Glitch> {

    public static int FUNCTIONMIN = 1000;
    public static int REGISTER_SOCIALIDGLITCH = 1001;
    public static int REGISTER_VERIFYGLITCH = 1002;
    public static int REGISTER_ISMANDATORYGLITCH = 1003;
    public static int FUNCTIONMAX = 1999;
    public static int GUIMIN = 2000;
    public static int TEXTFIELDGLITCH = 2001;
    public static int PASSWORDFIELDGLITCH = 2002;
    public static int GUIMAX = 2999;
    private String longDescription, shortDescription;
    private int overrideID;

    protected Glitch() {
        shortDescription = "Short Description";
        longDescription = "Long Description";
        overrideID = -1;
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

    public abstract Object performGlitch(Object... args);

    @Override
    public int compareTo(Glitch glitch) {
        return shortDescription.compareTo(glitch.getShortDescription());
    }
}
