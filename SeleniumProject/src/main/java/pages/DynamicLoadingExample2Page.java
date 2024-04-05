package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample2Page extends BasePage {

    private final By START_BUTTON = By.tagName("button");
    private final By LOADED_TEXT = By.id("finish");
//    private final By LOADER = By.id("loading");
    public DynamicLoadingExample2Page(WebDriver driver) {
        super(driver);
    }

    public void clickStartButton() {
        driver.findElement(START_BUTTON).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(LOADED_TEXT));
    }

    public String getLoadedText() {
        return driver.findElement(LOADED_TEXT).getText();
    }
}
