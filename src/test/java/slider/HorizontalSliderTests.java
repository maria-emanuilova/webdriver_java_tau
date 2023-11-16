package slider;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {
    private HorizontalSliderPage sliderPage;

    @BeforeClass
    public void navigateToHorizontalSliderPage() {
        sliderPage = homePage.clickHorizontalSlider();
    }

    @Test
    public void testCheckSliderRange() {
        sliderPage.changeRange(8);
        assertEquals(sliderPage.getRangeNumber(),"4", "Range number doesn't match");
    }
}
