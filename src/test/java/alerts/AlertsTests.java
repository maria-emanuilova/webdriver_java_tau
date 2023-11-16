package alerts;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {
    private AlertsPage alertsPage;

    @BeforeClass
    public void navigateToJSAlertsPage() {
        alertsPage = homePage.clickJavaScriptAlerts();
    }

    @Test
    public void testVerifyUserCanAcceptAlert() {
        alertsPage.clickTriggerAlertButton();
        alertsPage.alert_clickToAccept();

        assertEquals(alertsPage.getResultMessageText(), "You successfully clicked an alert",
                "Check result message text");
    }

    @Test
    public void testGetTextFromAlert() {
        alertsPage.clickTriggerConfirmButton();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();

        assertEquals(text, "I am a JS Confirm", "Check the alert text");
    }

    @Test
    public void testInputTextInAlert() {
        alertsPage.clickTriggerPromptButton();
        String inputText = "QA-s rock!";
        alertsPage.alert_enterText(inputText);
        alertsPage.alert_clickToAccept();

        assertEquals(alertsPage.getResultMessageText(), "You entered: " + inputText);
    }
}
