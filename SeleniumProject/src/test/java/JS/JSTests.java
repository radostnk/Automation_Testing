package JS;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LargeDeepDOMPage;

public class JSTests extends BaseTests {

    private LargeDeepDOMPage largeDeepDOMPage;

    @BeforeMethod
    public void instantiatePage() {
        largeDeepDOMPage = homePage.clickLargeDeepDOMPage();
    }

    @Test
    public void scrollToTable() {
        largeDeepDOMPage.scrollToTable();
        
    }
}
