package com.sigma.qsab.glitches;

public class GlitchManagersSingleton {
    
    private static FunctionGlitchManager functionGlitchManager;
    private static GUIGlitchManager guiGlitchManager;
    
    
    private GlitchManagersSingleton() {
        functionGlitchManager = new FunctionGlitchManager();
        guiGlitchManager = new GUIGlitchManager();
    }
    
    public static GlitchManagersSingleton getInstance() {
        return GlitchManagersSingletonHolder.INSTANCE;
    }

    public FunctionGlitchManager getFunctionGlitchManager() {
        return functionGlitchManager;
    }

    public GUIGlitchManager getGUIGlitchManager() {
        return guiGlitchManager;
    }
        
    
    private static class GlitchManagersSingletonHolder {

        private static final GlitchManagersSingleton INSTANCE = new GlitchManagersSingleton();
    }
}
