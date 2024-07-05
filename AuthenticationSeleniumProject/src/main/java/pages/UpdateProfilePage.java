package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfilePage {

    private WebDriver driver;
    private final By usernameEditField = By.id("editUsername");
    private final By emailEditField = By.id("editEmail");
    private final By phoneNumberEditField = By.id("editPhoneNumber");
    private final By passwordEditField = By.id("editPassword");
    private final By updateProfileButton = By.xpath("//button[text()='Update Profile']");

    public UpdateProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void editUsername(String newUsername) {
        WebElement usernameField = driver.findElement(usernameEditField);
        usernameField.clear();
        usernameField.sendKeys(newUsername);
        clickUpdateProfileBtn();
    }

    public void editEmail(String newEmail) {
        WebElement emailField = driver.findElement(emailEditField);
        emailField.clear();
        emailField.sendKeys(newEmail);
        clickUpdateProfileBtn();
    }

    public void editPhoneNumber(String newPhoneNumber) {
        WebElement phoneNumberField = driver.findElement(phoneNumberEditField);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(newPhoneNumber);
        clickUpdateProfileBtn();
    }

    public void editPassword(String newPassword) {
        WebElement passwordField = driver.findElement(passwordEditField);
        passwordField.clear();
        passwordField.sendKeys(newPassword);
        clickUpdateProfileBtn();
    }

    private void clickUpdateProfileBtn() {
        driver.findElement(updateProfileButton).click();
    }
}
