package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final String FORM_AUTHENTICATION_TEXT = "Form Authentication";
    private final String DROPDOWN_TEXT = "Dropdown";
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication() {
        this.clickLink(FORM_AUTHENTICATION_TEXT);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        this.clickLink(DROPDOWN_TEXT);
        return new DropdownPage(driver);
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
