package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private static final By CHOOSE_FILE_BUTTON = By.id("file-upload");
    private static final By SUBMIT_FILE_BUTTON = By.id("file-submit");
    private static final By UPLOADED_FILES_TEXT = By.id("uploaded-files");
    private static final By PAGE_TITLE_TEXT = By.tagName("h1");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit() {
        driver.findElement(SUBMIT_FILE_BUTTON).click();
    }

    public void uploadFile(String filePath) {
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys(filePath);
        this.clickSubmit();
    }

    public String getUploadedFilesText() {
        return driver.findElement(UPLOADED_FILES_TEXT).getText();
    }

    public String getPageTitleText() {
        return driver.findElement(PAGE_TITLE_TEXT).getText();
    }
}
