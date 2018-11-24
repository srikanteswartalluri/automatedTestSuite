package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginFirstPage;
import pages.LoginPage;

import java.util.Set;

public class LoginTest extends TestBase{
    LoginPage lPage;
    String parentWindowHandle;
    @BeforeMethod
    public void Login(){
        HomePage hPage = new HomePage(driver);
        lPage = hPage.clickLogin();
        parentWindowHandle = driver.getWindowHandle();
    }
    @Test(enabled = true, description = "test to sign in and sign out")
    public void testLogin() throws InterruptedException {
        lPage.enterEmail("talluri.work@gmail.com");
        lPage.enterPassword("Bonify1234$");
        LoginFirstPage lFPage = lPage.clickLogin();
        String name = lFPage.getUserName();
        lFPage.clickSignOut();
        Assert.assertEquals("srikanteswaraRao talluri", name,
                        "User Name did not match");

    }

    @Test(enabled = true, description = "test to check the forgot password link")
    public void testForgotPassword(){
        lPage.clickForgotPassword();
        String header = driver.findElement(By.xpath("//*[@id=\"step-{{$index}}\"]/div/form/h1")).getText();
        Assert.assertEquals("Email senden", header,
                "header did not match");

    }

    @Test(enabled = true, description = "test to check the register link")
    public void testRegister(){
        lPage.clickRegister();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://my.bonify.de/register/email", url,
                "URL did not match");

    }

    @Test(enabled = true, description = "test to check the imprint link")
    public void testImprint(){
        lPage.clickImprint();
        Set<String> wHandles = driver.getWindowHandles();
        for(String w : wHandles){
            if(!w.equals(parentWindowHandle)){
                //switch the control to new tab
                driver.switchTo().window(w).getTitle();
                String title = lPage.getTitle();
                ////close the new tab
                driver.close();
                //switch the control to parent tab
                driver.switchTo().window(parentWindowHandle);
                Assert.assertEquals("Impressum bonify", title,
                        "Title did not match");
            }
        }
    }

    @Test(enabled = true, description = "test to check conditions link")
    public void testConditions(){
        lPage.clickConditions();
        Set<String> wHandles = driver.getWindowHandles();
        for(String w : wHandles){
            if(!w.equals(parentWindowHandle)){
                //switch the control to new tab
                driver.switchTo().window(w).getTitle();
                String title = lPage.getTitle();
                //close the new tab
                driver.close();
                //switch the control to parent tab
                driver.switchTo().window(parentWindowHandle);
                Assert.assertEquals("bonify - AGB", title,
                        "Title did not match");
            }
        }
    }

    @Test(enabled = true, description = "test to check data protection link")
    public void testDataProtection(){
        lPage.clickDataProtection();
        Set<String> wHandles = driver.getWindowHandles();
        for(String w : wHandles){
            if(!w.equals(parentWindowHandle)){
                //switch the control to new tab
                driver.switchTo().window(w).getTitle();
                String title = lPage.getTitle();
                //close the new tab
                driver.close();
                //switch the control to parent tab
                driver.switchTo().window(parentWindowHandle);
                Assert.assertEquals("Datenschutz bei bonify - Sicherheit ist sehr wichtig für die Bonitätsprüfung", title,
                        "Title did not match");
            }

        }
    }

    @AfterMethod
    public void cleanUp(){
        //navigate to my.bonify.de page after each method
        lPage.reset();
    }




}
