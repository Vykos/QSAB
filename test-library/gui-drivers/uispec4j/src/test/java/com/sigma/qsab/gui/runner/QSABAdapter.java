/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.qsab.gui.runner;

import com.sigma.qsab.QSAB;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.Window;

public class QSABAdapter implements UISpecAdapter{

    @Override
    public Window getMainWindow() {
        return new Window((new QSAB()).getMainFrame());
    }    
}
