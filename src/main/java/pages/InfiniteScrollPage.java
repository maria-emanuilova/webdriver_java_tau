package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By scrollAdded = By.className("jscroll-added");
    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    //index is 1-based
    //scrolls down until n-th (index) paragraph
    public void scrollDownToParagraph(int index)  {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;

        while(getNumberOfParagraphsPresent() < index) {
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent() {
        return driver.findElements(scrollAdded).size();
    }
}
