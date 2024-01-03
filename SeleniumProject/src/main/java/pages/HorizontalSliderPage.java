package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage {

    private final By SLIDER = By.tagName("input");
    private final By RESULT = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public void slideRight(int slidePoints) {
        for (int i = 1; i <= slidePoints; i++) {
            driver.findElement(SLIDER).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void slideLeft(int slidePoints) {
        for (int i = 1; i <= slidePoints; i++) {
            driver.findElement(SLIDER).sendKeys(Keys.ARROW_LEFT);
        }
    }

    public int getResult() {
        return Integer.parseInt(driver.findElement(RESULT).getText());
    }
}
