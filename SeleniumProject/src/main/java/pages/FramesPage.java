package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    private final By NESTED_FRAMES = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage clickNestedFramesLink() {
        driver.findElement(NESTED_FRAMES).click();
        return new NestedFramesPage(driver);
    }
}
