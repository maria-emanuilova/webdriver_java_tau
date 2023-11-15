package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption isn't displayed");
        assertEquals(caption.getTitle(), "name: user1", "Title isn't correct");
        assertEquals(caption.getLinkText(), "View profile", "Check link text");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link is incorrect");
    }
}
