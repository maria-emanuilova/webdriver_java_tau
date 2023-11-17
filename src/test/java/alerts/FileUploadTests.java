package alerts;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    private FileUploadPage uploadPage;
    @BeforeClass
    public void navigateToFileUploadPage() {
        uploadPage = homePage.clickFileUpload();
    }

    @Test
    public void testFileUpload() {
        uploadPage.uploadFile("...\\IdeaProjects\\webdriver_java_tau\\src\\main\\resources\\testFile.text");

        assertEquals(uploadPage.getUploadedFiles(), "testFile.text");
    }
}
