package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends BasePage {

    private static final By IFRAME = By.id("mce_0_ifr");
    private static final By TEXT_AREA = By.id("tinymce");
    private static final By INCREASE_INDENTATION_BUTTON = By.xpath("//button[contains(@aria-label, 'Increase')]");

    public WysiwygEditorPage(WebDriver driver) {
        super(driver);
    }

    public void clearTextArea() {
        this.switchToEditor();
        driver.findElement(TEXT_AREA).clear();
        this.switchToMainArea();
    }

    public void inputText(String text) {
        this.switchToEditor();
        driver.findElement(TEXT_AREA).sendKeys(text);
        this.switchToMainArea();
    }

    public void clickIncreaseIndentationButton() {
        driver.findElement(INCREASE_INDENTATION_BUTTON).click();
    }

    public String getEnteredText() {
        this.switchToEditor();
        String text = driver.findElement(TEXT_AREA).getText();
        this.switchToMainArea();
        return text;
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    private void switchToEditor() {
        driver.switchTo().frame(driver.findElement(IFRAME));
    }
}
