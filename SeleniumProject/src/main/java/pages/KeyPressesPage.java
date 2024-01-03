package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage extends BasePage {

    private final By INPUT_FIELD = By.id("target");
    private final By RESULT = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        driver.findElement(INPUT_FIELD).sendKeys(text);
    }

    public void enterPi() {
        this.enterText(Keys.chord(Keys.ALT + "p") + "=3.14");
    }

    public String getResult() {
        return driver.findElement(RESULT).getText();
    }

}
