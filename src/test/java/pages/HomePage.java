package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;
import sun.rmi.runtime.Log;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,300);
        //PageFactory.initElements(driver, this);

    }

//    //locators
//    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/div[3]/div[2]/a")
//    WebElement login;

    By login = By.xpath("/html/body/div[1]/header/div[1]/div/div[3]/div[2]/a");


    public LoginPage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(login));
        driver.findElement(login).click();
//        login.click();
        return new LoginPage(driver);
    }

}
