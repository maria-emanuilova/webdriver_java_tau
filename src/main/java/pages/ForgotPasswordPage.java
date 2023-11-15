package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailInputField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#forgot_password button");
    private By mesage = By.tagName("h1");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailInputField).sendKeys(email);
    }

    public void clickRetrievePassword(){
        driver.findElement(retrievePasswordButton).click();
    }

    public String getMessageText() {
        return driver.findElement(mesage).getText();
    }
}
