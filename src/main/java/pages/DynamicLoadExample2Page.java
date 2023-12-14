package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadExample2Page {
    private WebDriver driver;
    private By finishBar = By.id("finish");
    private By startButton = By.cssSelector("#start button");

    public DynamicLoadExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(finishBar));

        /*FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));*/
    }

    public String getFinishBarText() {
        return driver.findElement(finishBar).getText();
    }
}
