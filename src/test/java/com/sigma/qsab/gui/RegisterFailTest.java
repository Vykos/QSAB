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

public class RegisterFailTest {

    private EmergencyAbortListener listener;
    private FrameFixture window;
    private GUIStrings gs;

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
        try {
            gs = new GUIStrings("/com/sigma/qsab/values/strings.txt");
        } catch (Exception e) {
        }
        window = new FrameFixture(frame);
        listener = EmergencyAbortListener.registerInToolkit();        
    }

    @Test
    public void testRegisterFillOut() {
        window.button("welcome_register").click();
        window.textBox("field_" + gs.getString(GUIStrings.FIRSTNAME)).setText("Test");
        window.textBox("field_" + gs.getString(GUIStrings.LASTNAME)).setText("Testsson");
        window.textBox("field_" + gs.getString(GUIStrings.SOCIALID)).setText("1212-121212");
        window.textBox("field_" + gs.getString(GUIStrings.STREET)).setText("Testvägen 55");
        window.textBox("field_" + gs.getString(GUIStrings.ZIPCODE)).setText("12345");
        window.textBox("field_" + gs.getString(GUIStrings.CITY)).setText("Testort");
        window.textBox("field_" + gs.getString(GUIStrings.PHONE)).setText("08-123456");
        window.textBox("field_" + gs.getString(GUIStrings.CELLPHONE)).setText("073-1234567");
        window.textBox("field_" + gs.getString(GUIStrings.EMAIL)).setText("test@test.com");
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORD)).setText("123456");
        window.textBox("field_" + gs.getString(GUIStrings.PASSWORDREPEAT)).setText("123456");
        window.button("register_next").click();
        window.label("text_" + gs.getString(GUIStrings.FIRSTNAME)).requireText("Test");
        window.label("text_" + gs.getString(GUIStrings.LASTNAME)).requireText("Testsson");
        window.label("text_" + gs.getString(GUIStrings.SOCIALID)).requireText("1212-121212");
        window.label("text_" + gs.getString(GUIStrings.STREET)).requireText("Testvägen 55");
        window.label("text_" + gs.getString(GUIStrings.ZIPCODE)).requireText("12345");
        window.label("text_" + gs.getString(GUIStrings.CITY)).requireText("Testort");
        window.label("text_" + gs.getString(GUIStrings.PHONE)).requireText("08-123456");
        window.label("text_" + gs.getString(GUIStrings.CELLPHONE)).requireText("073-1234567");
        window.label("text_" + gs.getString(GUIStrings.EMAIL)).requireText("test@test.com");
        window.label("text_" + gs.getString(GUIStrings.PASSWORD)).requireText("123456");
        window.label("text_" + gs.getString(GUIStrings.PASSWORDREPEAT)).requireText("123456");          
    }

    @After
    public void tearDown() {
        listener.unregister();
        window.cleanUp();
    }
}
