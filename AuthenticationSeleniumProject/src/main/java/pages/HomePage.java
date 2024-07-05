package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.id("login-tab")).click();
        return new LoginPage(driver);
    }

    public UpdateProfilePage goToUpdateProfilePage() {
        driver.findElement(By.id("login-tab")).click();
        return new UpdateProfilePage(driver);
    }

    public void goToProfile() {
        driver.navigate().to("file:///C:/Users/koleva/Desktop/test-login-app-main/profile.html");
    }
}
