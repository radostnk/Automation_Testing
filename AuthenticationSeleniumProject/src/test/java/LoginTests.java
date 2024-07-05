import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import pages.LoginPage;

import java.util.Set;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;
    private final String username = "janeDoe";
    private final String email = "jane@example.com";
    private final String pass = "password456";

    @BeforeEach
    public void instantiatePage() {
        loginPage = homePage.goToLoginPage();
    }

    @Test
    public void loginSuccessfully_usingUsername() {

        loginPage.fullLoginProcedureNotRemember(username, pass);
        Assertions.assertEquals(username, loginPage.getUsername());
        loginPage.logout();
    }

    @Test
    public void loginSuccessfully_usingEmail() {

        loginPage.fullLoginProcedureNotRemember(email, pass);
        Assertions.assertEquals(username, loginPage.getUsername());
        loginPage.logout();
    }

    @Test
    public void loginSuccessfully_withRememberMe() {

        //login
        loginPage.fullLoginProcedureRemember(username, pass);

        Assertions.assertEquals(username, loginPage.getUsername());
        loginPage.logout();

        //send old cookies containing the rememberMe to the
        //new session and directly navigate to profile without login
        //should this fail, there is an issue with the rememberMe

        Set<Cookie> oldSessionCookies = loginPage.getOldSessionCookies();

        tearDown();
        setUp();

        loginPage.addOldCookiesToNewSession(oldSessionCookies);

        homePage.goToProfile();
        Assertions.assertEquals(username, loginPage.getUsername());
        loginPage.logout();
    }
}
