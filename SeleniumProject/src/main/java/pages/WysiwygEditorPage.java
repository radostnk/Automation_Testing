package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends BasePage {

    private static final By IFRAME = By.id("mce_0_ifr");

    public WysiwygEditorPage(WebDriver driver) {
        super(driver);
    }

    private void switchToIframe() {
        driver.switchTo().frame(driver.findElement(IFRAME));
    }


}
