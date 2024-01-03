package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final String FORM_AUTHENTICATION_TEXT = "Form Authentication";
    private final String DROPDOWN_TEXT = "Dropdown";
    private final String HOVERS_TEXT = "Hovers";
    private final String KEY_PRESSES = "Key Presses";
    private final String HORIZONTAL_SLIDER = "Horizontal Slider";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickFormAuthentication() {
        this.clickLink(FORM_AUTHENTICATION_TEXT);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        this.clickLink(DROPDOWN_TEXT);
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers() {
        this.clickLink(HOVERS_TEXT);
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        this.clickLink(KEY_PRESSES);
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        this.clickLink(HORIZONTAL_SLIDER);
        return new HorizontalSliderPage(driver);
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
