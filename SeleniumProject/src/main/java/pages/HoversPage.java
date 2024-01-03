package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends BasePage {

    private final By FIGURE_BOX = By.className("figure");
    private final By BOX_CAPTION = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @param index starts at 1
     */

    public FigureCaption hoverOverFigure(int index) {
        List<WebElement> figureBox = driver.findElements(FIGURE_BOX);
        WebElement desiredFigure = figureBox.get(index - 1);

        //In order to hover over an object or perform some other advanced interaction,
        //we need to use the Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(desiredFigure).perform();

        return new FigureCaption(desiredFigure.findElement(BOX_CAPTION));
    }

    public class FigureCaption {

        private WebElement caption;
        private final By HEADER = By.tagName("h5");
        private final By PROFILE_LINK = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return this.caption.isDisplayed();
        }

        public String getTitle() {
            return this.caption.findElement(HEADER).getText();
        }

        public String getProfileLink() {
            return this.caption.findElement(PROFILE_LINK).getAttribute("href");
        }

        public String getProfileLinkText() {
            return this.caption.findElement(PROFILE_LINK).getText();
        }
    }
}
