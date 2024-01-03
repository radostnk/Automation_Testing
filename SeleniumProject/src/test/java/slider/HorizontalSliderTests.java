package slider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.slideRight(4);
        Assert.assertEquals(horizontalSliderPage.getResult(), 2,"Slide right does not work properly!");
        horizontalSliderPage.slideLeft(2);
        Assert.assertTrue(horizontalSliderPage.getResult() == 1, "Slide left does not work properly!");
    }

}
