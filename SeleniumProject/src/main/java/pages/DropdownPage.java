package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage {

    private final By DROPDOWN = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectFromDropdown(String option) {
        this.findDropdown().selectByVisibleText(option);
    }

    public List<String> getSelectedOption() {

        //In order to interact with a  dropdown, we need a new dependency: selenium-support
        List<WebElement> allSelectedOptions = this.findDropdown().getAllSelectedOptions();
        return allSelectedOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropdown() {
        return new Select(driver.findElement(DROPDOWN));
    }
}
