package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorPage {
    private WebDriver driver;
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }
    private String editorIframeId = "mce_0_ifr";
    private By inputTextArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[5]/button[1]");

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(inputTextArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(inputTextArea).clear();
        driver.findElement(inputTextArea).sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndentation() {
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(inputTextArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditArea() {
        this.driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        this.driver.switchTo().parentFrame();
    }
}
