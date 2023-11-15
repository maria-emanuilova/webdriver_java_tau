package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
       DropdownPage dropdownPage = homePage.clickDropdown();

       String option = "Option 1";
       dropdownPage.selectFromDropdown(option);
       var selectedOptions = dropdownPage.getSelectedOptions();
       assertEquals(selectedOptions.size(), 1);
       assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
