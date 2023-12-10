package frames;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    private WysiwygEditorPage editorPage;
    private FramesPage framesPage;
    private NestedFramesPage nestedFramesPage;


    @Test
    public void testWysiwyg() {
        editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello QA world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();

        assertEquals(editorPage.getTextFromEditor(), text1, "Text is not correct");
    }

    @Test
    public void testCheckNestedFramesText() {
        nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        assertEquals(nestedFramesPage.getLeftFrameAreaText(), "LEFT", "Left frame text is incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom frame text is incorrect");
    }
}
