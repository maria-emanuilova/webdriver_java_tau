package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void changeDropdownScript() {
        String script = "document.querySelector('#dropdown').setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script, findDropdownElement());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown));
    }
}
