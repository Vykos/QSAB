package com.sigma.qsab.gui;

//Requires Fest library:
import com.sigma.qsab.QSAB;
import org.fest.swing.core.EmergencyAbortListener;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;

//Requires JUnit 4.1 library:
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

public class RegisterTest {

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

    @Test
    public void testRegisterFillOut() throws InterruptedException {
        lib.clickButton("welcome_register");
        lib.fillInName("Test", "Testsson");
        lib.fillInSocialID("121212-1212");
        lib.fillInAddress("Testvägen 55", "12345", "Testort");
        lib.fillInPhoneNumber("08-123456");
        lib.fillInCellPhoneNumber("073-1234567");
        lib.fillInEmail("test@test.com");
        lib.fillInPasswordTwice("123456");
        lib.clickButton("register_next");
        //Thread.sleep(5000);
        lib.assertName("Test", "Testsson");
        lib.assertSocialID("121212-1212");
        lib.assertAddress("Testvägen 55", "12345", "Testort");
        lib.assertPhoneNumber("08-123456");
        lib.assertCellPhoneNumber("073-1234567");
        lib.assertEmail("test@test.com");
        lib.assertPasswords("123456");                        
    }

    @After
    public void tearDown() {
        listener.unregister();
        window.cleanUp();
    }
}
