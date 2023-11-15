package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExerciseChapter3 {
    private WebDriver driver;
    public void exerciseTest() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement linkShiftingContent = driver.findElement(By.linkText("Shifting Content"));
        linkShiftingContent.click();

        WebElement linkExample1 = driver.findElement(By.linkText("Example 1: Menu Element"));
        linkExample1.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));
        System.out.println("The number of link options in the list is " + links.size());

        driver.quit();
    }

    public static void main(String[] args){
        ExerciseChapter3 test = new ExerciseChapter3();
        test.exerciseTest();
    }
}
