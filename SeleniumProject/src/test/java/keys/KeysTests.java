package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeysTests extends BaseTests {

    private KeyPressesPage keyPressesPage;

    @BeforeMethod
    public void instantiatePage() {
        keyPressesPage = homePage.clickKeyPresses();
    }

    @Test
    public void testBackSpace() {
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi() {
        keyPressesPage.enterPi();
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: 4");
    }
}
