package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeysTests extends BaseTests {

    @Test
    public void testBackSpace() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE");
    }

//    @Test
//    public void testPi() {
//        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
//        keyPressesPage.enterPi();
//        Assert.assertEquals(keyPressesPage.getResult(), "You entered: 4");
//    }
}
