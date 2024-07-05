import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private final By userOrEmailField = By.id("usernameOrEmail");
    private final By passwordField = By.id("password");
    private final By rememberMeCheckbox = By.id("rememberMe");
    private final By loginButton = By.className("btn btn-primary");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertUserOrEmail(String userOrEmail) {
        driver.findElement(userOrEmailField).sendKeys(userOrEmail);
    }

    public void insertPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
