package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[text() = 'Click for JS Alert']");
    private By triggerConfirmButton = By.xpath("//button[text() = 'Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//button[text() = 'Click for JS Prompt']");
    private By resultMessage = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTriggerAlertButton() {
        driver.findElement(triggerAlertButton).click();
    }

    public void clickTriggerConfirmButton() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void clickTriggerPromptButton() {
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_enterText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    public String getResultMessageText() {
        return driver.findElement(resultMessage).getText();
    }
}
