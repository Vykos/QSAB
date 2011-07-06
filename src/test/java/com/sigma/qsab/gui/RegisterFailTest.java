package com.sigma.qsab.gui;

import com.sigma.qsab.QSAB;
import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterFailTest {

    private EmergencyAbortListener listener;
    private FrameFixture window;
    private RegisterLibrary lib;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        MainFrame frame = GuiActionRunner.execute(new GuiQuery<MainFrame>() {

            protected MainFrame executeInEDT() {
                return (new QSAB()).getMainFrame();
            }
        });
        window = new FrameFixture(frame);
        listener = EmergencyAbortListener.registerInToolkit();
        lib = new RegisterLibrary(window);
    }

    @After
    public void tearDown() {
        listener.unregister();
        window.cleanUp();
    }

    @Test
    public void testRegisterFillOut() {
        fillOutForm();

        lib.clickButton("register_next");
        pause(5000);

        assertForm();
    }

    private void findForm() {
        lib.clickButton("welcome_login");
        window.list("superadmin_glitchlist").clickItem("Formateringsfel i personnummer");
        lib.clickButton("superadmin_accept");
        lib.clickButton("welcome_register");
    }

    private void fillOutForm() {
        findForm();

        lib.fillInName("Test", "Testsson");
        lib.fillInSocialID("1212-121212");
        lib.fillInAddress("Testvägen 55", "12345", "Testort");
        lib.fillInPhoneNumber("08-123456");
        lib.fillInCellPhoneNumber("073-1234567");
        lib.fillInEmail("test@test.com");
        lib.fillInPasswordTwice("123456");
    }

    private void assertForm() {
        lib.assertName("Test", "Testsson");
        lib.assertSocialID("1212-121212");
        lib.assertAddress("Testvägen 55", "12345", "Testort");
        lib.assertPhoneNumber("08-123456");
        lib.assertCellPhoneNumber("073-1234567");
        lib.assertEmail("test@test.com");
        lib.assertPasswords("123456");
    }

    private void pause(long timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
