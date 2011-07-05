package com.sigma.qsab.glitches;

import java.util.HashMap;

public abstract class GlitchManager {

    private HashMap<Integer,Glitch> glitchMap;

    public GlitchManager() {
        glitchMap =  new HashMap<Integer, Glitch>();
    }        

    public HashMap<Integer, Glitch> getGlitchMap() {
        return glitchMap;
    }

    public void setGlitchMap(HashMap<Integer, Glitch> glitchMap) {
        this.glitchMap = glitchMap;
    }
    
    public void clearGlitchMap() {
        setGlitchMap(new HashMap<Integer, Glitch>());
    }
    
    public void putGlitch(Glitch glitch) {
        glitchMap.put(glitch.getOverrideID(), glitch);                
    }
    
    public Glitch getGlitch(int overrideID) {
        return glitchMap.get(overrideID);
    }
    
    public boolean glitchExists(Glitch glitch) {
        return glitch != null;
    }
}
