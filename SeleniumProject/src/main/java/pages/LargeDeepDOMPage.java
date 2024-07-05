package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeDeepDOMPage extends BasePage {

    private final By TABLE = By.id("large-table");
    public LargeDeepDOMPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToTable() {
        WebElement table = driver.findElement(TABLE);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, table);
    }


}
