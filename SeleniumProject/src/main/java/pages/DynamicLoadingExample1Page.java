package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.InstantSource;


public class DynamicLoadingExample1Page extends BasePage {

    private final By START_BUTTON = By.cssSelector("#start button");
    private final By LOADER = By.id("loading");
    private final By LOADED_TEXT = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        super(driver);
    }

    public void clickStartButton() {
        driver.findElement(START_BUTTON).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(LOADER)));
    }

    public String getLoadedText() {
        return driver.findElement(LOADED_TEXT).getText();
    }

}
