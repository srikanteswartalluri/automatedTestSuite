package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static WebDriver driver = null;

    @BeforeSuite
    public void initialize() throws IOException{

        System.setProperty("webdriver.chrome.driver", "/Users/talluri/Downloads/chromedriver");
        //open chrome browser
        driver = new ChromeDriver();
        //page load timeout
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To open bonify.de
        driver.get("https://www.bonify.de");

    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        TestBase.driver.quit();
    }

}