package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static java.lang.Thread.sleep;

public class LoginFirstPage {

    WebDriver driver;
    WebDriverWait wait;

    //locators
    By nameButton = By.xpath("//*[@id=\"main-header\"]/div[1]/div/div[2]/button");

    By signOut = By.xpath("*[@id=\"main-body\"]/ul[1]/li[4]");

    By drpDown = By.xpath("//*[@id=\"main-body\"]/ul[1]/li");


    public LoginFirstPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void clickSignOut() throws InterruptedException {

        driver.findElement(nameButton).click();
        List<WebElement> uls = driver.findElements(drpDown);
        if(uls.size() == 4) {
            uls.get(3).click();
        }else{
            Assert.fail("not able to find signout button");
        }
    }

    public String getUserName(){
        String name = driver.findElement(nameButton).getText();
        return name;
    }
}
