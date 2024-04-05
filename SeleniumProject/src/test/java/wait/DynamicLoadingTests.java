package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;

public class DynamicLoadingTests extends BaseTests {

    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void instantiatePage() {
        dynamicLoadingPage = homePage.clickDynamicLoadingPage();
    }

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingExample1Page dynamicLoadingExample1Page = dynamicLoadingPage.clickExample1();
        dynamicLoadingExample1Page.clickStartButton();
        String loadedTextActual = dynamicLoadingExample1Page.getLoadedText();
        Assert.assertEquals(loadedTextActual, "Hello World!");
    }

    @Test
    public void testWaitUntilAppears() {
        DynamicLoadingExample2Page dynamicLoadingExample2Page = dynamicLoadingPage.clickExample2();
        dynamicLoadingExample2Page.clickStartButton();
        String loadedTextActual = dynamicLoadingExample2Page.getLoadedText();
        Assert.assertEquals(loadedTextActual, "Hello World!");
    }
}