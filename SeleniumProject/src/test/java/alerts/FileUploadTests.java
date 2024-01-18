package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {

    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void instantiatePage() {
        fileUploadPage = homePage.clickFileUpload();
    }

    @Test
    public void testUploadFile() {
        fileUploadPage.uploadFile("D:\\Automation Learning\\Automation_Testing\\SeleniumProject\\resources\\chromedriver.exe");
        Assert.assertEquals("chromedriver.exe", fileUploadPage.getUploadedFilesText());
    }

    @Test
    public void testUploadNothing() {
        fileUploadPage.clickSubmit();
        Assert.assertEquals("Internal Server Error", fileUploadPage.getPageTitleText());
    }
}
