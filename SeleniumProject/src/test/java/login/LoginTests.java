package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;


public class LoginTests extends BaseTests {

    private final String USERNAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";
    private final String ALERT_EXPECTED = "You logged into a secure area!";

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword(PASSWORD);
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertTextActual = secureAreaPage.getAlertText();
        assertTrue(alertTextActual.contains("You logged into a secure area!"));
    }
}
