package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {

    private ContextMenuPage contextMenuPage;

    @BeforeMethod
    public void instantiatePage() {
        contextMenuPage = homePage.clickContextMenuPage();
    }

    @Test
    public void testAlertText() {
        contextMenuPage.rightClickContextMenu();
        String actual = contextMenuPage.getAlertText();
        String expected = "You selected a context menu";
        contextMenuPage.clickOkButton();
        Assert.assertEquals(actual, expected);
    }
}
