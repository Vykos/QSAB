package com.sigma.qsab.gui;

import com.sigma.qsab.glitches.Glitch;

public class CheckListItem {
    private Glitch glitch;
    private boolean isSelected = false;

    public CheckListItem(Glitch glitch) {
        this.glitch = glitch;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    public Glitch getGlitch() {
        return glitch;
    }

    @Override
    public String toString() {
        return glitch.getShortDescription();
    }
}
