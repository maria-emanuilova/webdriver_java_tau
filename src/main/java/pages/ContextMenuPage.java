package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class ContextMenuPage {
    private WebDriver driver;
    private By contextArea = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickContextArea() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextArea)).perform();
    }
}
