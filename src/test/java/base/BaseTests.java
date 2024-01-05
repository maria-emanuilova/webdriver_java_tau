package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    protected EventFiringWebDriver driver;
    protected HomePage homePage;
    protected String baseUrl = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        driver.get(baseUrl);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    //this will execute after each test runs
    public void recordFailure(ITestResult result) {
        //to take screenshots only when test FAILS:
        if(ITestResult.FAILURE == result.getStatus()) {
            //we cast our driver to the Selenium screenshot taking class:
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE); //screenshot will be saved as file
            try {
                Files.move(screenshot, new File("src/main/resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}

