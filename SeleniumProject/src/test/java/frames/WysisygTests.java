package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

public class WysisygTests extends BaseTests {

    WysiwygEditorPage wysiwygEditorPage;

    @BeforeMethod
    public void instantiatePage() {
        wysiwygEditorPage = homePage.clickWysiwygEditorPage();
    }

    @Test
    public void testWysiwyg() {
        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.inputText("Hello ");
        wysiwygEditorPage.clickIncreaseIndentationButton();
        wysiwygEditorPage.inputText("World!");
        Assert.assertEquals(wysiwygEditorPage.getEnteredText(), "Hello World!");
    }
}
