package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    //locators
    By email = By.name("email");
    By password = By.name("password");
    By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/div[4]/div[1]/button");
    By forgotPassword = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/div[3]/a");
    By register = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/div[4]/div[2]/a/button");
    By imprint = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/ul/li[1]/a");
    By conditions = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/ul/li[2]/a");
    By dataProtection = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/ul/li[3]/a");

    public void enterEmail(String userEmail){
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }

    public LoginFirstPage clickLogin(){
        driver.findElement(loginButton).click();
        return new LoginFirstPage(driver);
    }

    public  void clickForgotPassword(){
        driver.findElement(forgotPassword).click();
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(register));
        driver.findElement(register).click();
    }

    public void clickImprint(){
        driver.findElement(imprint).click();
    }

    public void clickConditions(){
        driver.findElement(conditions).click();
    }

    public void clickDataProtection(){
        driver.findElement(dataProtection).click();
    }

    public void reset(){
        driver.navigate().to("https://www.bonify.de");
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
