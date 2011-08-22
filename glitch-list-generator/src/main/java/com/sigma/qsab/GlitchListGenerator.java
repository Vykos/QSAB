package com.sigma.qsab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GlitchListGenerator {

    String relativeGlitchPath = "../implementation/src/main/java/com/sigma/qsab/glitches/customglitches/";
    String relativePropertyPath = "../implementation/src/main/resources/glitches.properties";
    ArrayList<String> glitchPathList;

    public GlitchListGenerator() {
        File glitchDirectory = new File(relativeGlitchPath);
        File[] files = glitchDirectory.listFiles();
        glitchPathList = generateFileList(files);
        for (String glitchPath : glitchPathList) {
            System.out.println(glitchPath);
        }
        File propertyFile = new File(relativePropertyPath);
        if (propertyFile.exists()) {
            propertyFile.delete();
        }
        Properties properties = new Properties();
        for (int i = 0; i < glitchPathList.size(); i++) {            
            properties.setProperty("" + i, glitchPathList.get(i));
            System.out.println(properties.getProperty("" + i));
        }
        try {
            properties.store(new FileOutputStream(propertyFile), "List of custom glitches.");
        } catch (IOException ex) {
            Logger.getLogger(GlitchListGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private ArrayList<String> generateFileList(File[] files) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (File file : files) {
            if (file.isDirectory()) {
                resultList.addAll(generateFileList(file.listFiles()));
            } else if (file.getName().endsWith(".java")) {
                String path = file.getPath();
                path = path.substring(32, path.length() - 5);
                path = path.replace(File.separator, ".");
                resultList.add(path);
            }
        }
        return resultList;
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        new GlitchListGenerator();
    }
}