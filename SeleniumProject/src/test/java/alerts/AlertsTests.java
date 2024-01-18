package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.JSAlertsPage;

public class AlertsTests extends BaseTests {

    private JSAlertsPage alertsPage;

    @BeforeMethod
    public void instantiatePage() {
        alertsPage = homePage.clickJSAlerts();
    }

    @Test
    public void testAcceptAlert() {
        alertsPage.clickTriggerAlertButton();
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getAlertResultText(), "You successfully clicked an alert");
    }

    @Test
    public void testConfirmAlertText() {
        alertsPage.clickTriggerConfirmAlertButton();
        Assert.assertEquals(alertsPage.getAlertText(), "I am a JS Confirm");
        alertsPage.acceptAlert();
    }

    @Test
    public void testCancelAlert() {
        alertsPage.clickTriggerConfirmAlertButton();
        alertsPage.cancelAlert();
        Assert.assertEquals(alertsPage.getAlertResultText(), "You clicked: Cancel");
    }

    @Test
    public void testPromptAlert() {
        String message = "My test message";
        alertsPage.clickTriggerPromptAlertButton();
        alertsPage.insertPromptMessage(message);
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getAlertResultText(), "You entered: " + message);
    }

}