package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public static final By CONTEXT_MENU = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickContextMenu() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(CONTEXT_MENU)).perform();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickOkButton() {
        driver.switchTo().alert().accept();
    }

}
