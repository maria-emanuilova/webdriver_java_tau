package alerts;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    private AlertsPage alertsPage;
    private ContextMenuPage contextMenuPage;

    @BeforeClass
    public void localSetUp() {
        this.alertsPage = new AlertsPage(driver);
        this.contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void testContextMenu() {
        contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickContextArea();
        var alertText = alertsPage.alert_getText();
        alertsPage.alert_clickToAccept();

        assertEquals(alertText, "You selected a context menu");
    }
}
