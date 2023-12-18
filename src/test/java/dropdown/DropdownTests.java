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

    @Test
    public void testSelectTwoOptions(){
        DropdownPage dropdownPage = homePage.clickDropdown();
        String option1 = "Option 1";
        String option2 = "Option 2";
        dropdownPage.changeDropdownScript();
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);

        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2);
        assertTrue(selectedOptions.contains(option1), "Option1 not selected");
        assertTrue(selectedOptions.contains(option2), "Option2 not selected");
    }
}
