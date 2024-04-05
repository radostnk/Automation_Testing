package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {

    private final By EXAMPLE_1 = By.linkText("Example 1: Element on page that is hidden");
    private final By EXAMPLE_2 = By.linkText("Example 2: Element on page that is hidden");
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(EXAMPLE_1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(EXAMPLE_2).click();
        return new DynamicLoadingExample2Page(driver);
    }
}
