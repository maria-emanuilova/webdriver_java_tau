package forgotPasword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import static org.testng.Assert.*;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void TestForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("tau@example.com");
        forgotPasswordPage.clickRetrievePassword();

        assertEquals(forgotPasswordPage.getMessageText(), "Internal Server Error", "Check the message text");
    }
}
