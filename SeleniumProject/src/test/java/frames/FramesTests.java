package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;

public class FramesTests extends BaseTests {

    private FramesPage framesPage;

    @BeforeMethod
    public void InstantiatePage() {
        framesPage = homePage.clickFramesPage();
    }

    @Test
    public void testNestedFrames() {
        NestedFramesPage nestedFramesPage = framesPage.clickNestedFramesLink();
        Assert.assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left frame text does not match!");
        Assert.assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom frame text does not match!");
    }
}
