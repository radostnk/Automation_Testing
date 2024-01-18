package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends BasePage {

    private final static By TRIGGER_ALERT_BUTTON = By.xpath(".//button[text()='Click for JS Alert']");
    private final static By TRIGGER_CONFIRM_ALERT_BUTTON = By.xpath(".//button[text()='Click for JS Confirm']");
    private final static By TRIGGER_PROMPT_ALERT_BUTTON = By.xpath(".//button[text()='Click for JS Prompt']");
    private final static By ALERT_RESULT = By.id("result");

    public JSAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickTriggerAlertButton() {
        driver.findElement(TRIGGER_ALERT_BUTTON).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertResultText() {
        return driver.findElement(ALERT_RESULT).getText();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickTriggerConfirmAlertButton() {
        driver.findElement(TRIGGER_CONFIRM_ALERT_BUTTON).click();
    }

    public void clickTriggerPromptAlertButton() {
        driver.findElement(TRIGGER_PROMPT_ALERT_BUTTON).click();
    }

    public void insertPromptMessage(String message) {
        driver.switchTo().alert().sendKeys(message);
    }
}