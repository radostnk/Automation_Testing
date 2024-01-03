package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.FigureCaption figureCaption = hoversPage.hoverOverFigure(1);

        Assert.assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed!");
        Assert.assertEquals(figureCaption.getTitle(), "name: user1", "Wrong title!");
        Assert.assertEquals(figureCaption.getProfileLinkText(), "View profile", "Wrong link text!");
        Assert.assertTrue(figureCaption.getProfileLink().endsWith("/users/1"), "Wrong link!");
    }
}
