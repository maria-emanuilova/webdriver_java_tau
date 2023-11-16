package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By rangeInput = By.xpath("//input[contains(@type,'range')]");
    private By rangeNumber = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void changeRange(int numberOfClicks) {
        for (int i = 0; i < numberOfClicks; i++) {
            driver.findElement(rangeInput).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRangeNumber(){
        return driver.findElement(rangeNumber).getText();
    }
}
