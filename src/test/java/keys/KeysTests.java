package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.AssertJUnit.assertEquals;

public class KeysTests extends BaseTests {
    private KeyPressesPage keyPage;

    @BeforeClass
    public void navigateToKeyPressesPage() {
        keyPage = homePage.clickPresses();
    }

    @Test
    public void testBackspace() {
       keyPage.enterText("A" + Keys.BACK_SPACE);

       assertEquals("You entered: BACK_SPACE", keyPage.getResultText());
    }

    @Test
    public void testALT() {
        keyPage.enterText("" + Keys.ALT);

        assertEquals("You entered: ALT", keyPage.getResultText());
    }

    @Test
    public void testPi() {
        keyPage.enterPi();
    }
}
