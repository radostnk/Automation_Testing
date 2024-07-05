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
}
