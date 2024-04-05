package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    private final String XPATH_FORMAT = "//a[contains(text(),'%d')]";
    private final By EXAMPLE_1 = By.xpath(String.format(XPATH_FORMAT, 1));
    private final By EXAMPLE_2 = By.xpath(String.format(XPATH_FORMAT, 2));
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
