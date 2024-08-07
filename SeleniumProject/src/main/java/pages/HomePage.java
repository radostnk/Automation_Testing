package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickFormAuthentication() {
        this.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        this.clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers() {
        this.clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        this.clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        this.clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JSAlertsPage clickJSAlerts() {
        this.clickLink("JavaScript Alerts");
        return new JSAlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        this.clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingPage() {
        this.clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public ContextMenuPage clickContextMenuPage() {
        this.clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditorPage() {
        this.clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesPage() {
        this.clickLink("Frames");
        return new FramesPage(driver);
    }

    public LargeDeepDOMPage clickLargeDeepDOMPage() {
        this.clickLink("Large & Deep DOM");
        return new LargeDeepDOMPage(driver);
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
