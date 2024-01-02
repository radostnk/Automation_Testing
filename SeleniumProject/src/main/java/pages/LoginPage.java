package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector("#login button");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        return new SecureAreaPage(driver);
    }
}
