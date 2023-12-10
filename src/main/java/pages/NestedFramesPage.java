package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrameArea = "frame-top";
    private String leftFrameArea = "frame-left";
    private String bottomFrameArea = "frame-bottom";
    private By frameText = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameAreaText() {
        switchToTopFrameArea();
        switchToLeftFrame();
        String leftText = getFrameText();
        switchToParentFrame();
        switchToParentFrame();

        return leftText;
    }

    public String getBottomFrameText() {
        switchToBottomFrame();
        String bottomText = getFrameText();
        switchToParentFrame();

        return bottomText;
    }

    private String getFrameText() {
       return this.driver.findElement(frameText).getText();
    }

    private void switchToParentFrame() {
        this.driver.switchTo().parentFrame();
    }

    private void switchToTopFrameArea() {
      this.driver.switchTo().frame(topFrameArea);
    }

    private void switchToLeftFrame() {
        this.driver.switchTo().frame(leftFrameArea);
    }

    private void switchToBottomFrame() {
        this.driver.switchTo().frame(bottomFrameArea);
    }
}
