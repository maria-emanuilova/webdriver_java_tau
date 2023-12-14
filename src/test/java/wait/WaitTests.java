package wait;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DynamicLoadExample1Page;
import pages.DynamicLoadingPage;
import pages.HomePage;

import static org.testng.AssertJUnit.assertEquals;

public class WaitTests extends BaseTests {


    @Test
    public void testWaitUntilHidden() {
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartButton();
        assertEquals(loadingPage.getLoadedText(), "Hello World!");
    }

    @Test
    public void testWaitUntilDisplayed() {
        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStartButton();
        assertEquals(loadingPage.getFinishBarText(), "Hello World!");
    }
}
