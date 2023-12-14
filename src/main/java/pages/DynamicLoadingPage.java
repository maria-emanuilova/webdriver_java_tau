package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By link_example1 = By.xpath("//a[contains(.,'Example 1')]");
    private By link_example2 = By.xpath(("//a[contains(.,'Example 2')]"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadExample1Page clickExample1() {
        driver.findElement(link_example1).click();
        return new DynamicLoadExample1Page(driver);
    }

    public DynamicLoadExample2Page clickExample2() {
        driver.findElement(link_example2).click();
        return new DynamicLoadExample2Page(driver);
    }
}
