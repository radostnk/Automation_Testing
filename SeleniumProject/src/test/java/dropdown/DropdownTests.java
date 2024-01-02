package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTests extends BaseTests {

    private final String OPTION = "Option 1";

    @Test
    public void testSelectOptionFromDropdown() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropdown(OPTION);
        List<String> selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption.size(), 1, "Incorrect number of selections!");
        Assert.assertEquals(selectedOption.get(0), OPTION, "Wrong option selected!");
    }
}
