package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {

    private final String LEFT_FRAME = "frame-left";
    private final String BOTTOM_FRAME = "frame-bottom";
    private final String TOP_FRAME = "frame-top";

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public String getLeftFrameText() {
        this.switchToLeftFrame();
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        this.switchToParent();
        this.switchToParent();
        return leftFrameText;
    }

    public String getBottomFrameText() {
        this.switchToBottomFrame();
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        this.switchToParent();
        return bottomFrameText;
    }

    private void switchToLeftFrame() {
        driver.switchTo().frame(TOP_FRAME);
        driver.switchTo().frame(LEFT_FRAME);
    }

    private void switchToBottomFrame() {
        driver.switchTo().frame(BOTTOM_FRAME);
    }

    private void switchToParent() {
        driver.switchTo().parentFrame();
    }

}
