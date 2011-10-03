package com.sigma.qsab.gui.runner;

import com.sigma.qsab.QSAB;
import org.uispec4j.Trigger;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowInterceptor;

public class QSABAdapter implements UISpecAdapter {

    @Override
    public Window getMainWindow() {
        return WindowInterceptor.run(new Trigger() {
            @Override
            public void run() {
                (new QSAB()).getMainFrame();
            }
        });
    }
}
