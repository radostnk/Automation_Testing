package slider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {

    private HorizontalSliderPage horizontalSliderPage;

    @BeforeMethod
    public void instantiatePage() {
        horizontalSliderPage = homePage.clickHorizontalSlider();
    }

    @AfterMethod
    public void resetSlider() {
        horizontalSliderPage.resetSlider();
    }

    @Test
    public void testSlideRight() {
        horizontalSliderPage.slideRight(4);
        Assert.assertEquals(horizontalSliderPage.getResult(), 2,"Slide right does not work properly!");
    }

    @Test
    public void testSlideLeft() {
        horizontalSliderPage.slideRight(4);
        horizontalSliderPage.slideLeft(2);
        Assert.assertTrue(horizontalSliderPage.getResult() == 1, "Slide left does not work properly!");
    }

}
