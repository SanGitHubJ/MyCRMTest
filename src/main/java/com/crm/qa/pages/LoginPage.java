package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
//import com.crm.qa.util.CaptureLogs;
import com.crm.qa.util.ScreenShotsHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class LoginPage extends TestBase {

    ScreenShotsHandle screenshot = new ScreenShotsHandle();
   // CaptureLogs getLogs = new CaptureLogs();

    //page factory OR Object Repo

    @FindBy(css="div[class=\"input-group\"]>input[name=\"username\"]")
    WebElement txtUserName;

    @FindBy(css = "div[class=\"input-group\"]>input[name=\"password\"]")
    WebElement txtPassword;

    @FindBy(xpath = "/html//form[@id='loginForm']//input[@value='Login']")
    WebElement btnloginbtn;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement lnkSingUp;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement imgCRM;


    //constructure to inizialioze ALL objects above
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateLoginPageTitle(){

        return driver.getTitle();

    }

    public boolean validateCRMImage(){

        return imgCRM.isDisplayed();
    }

    public HomePage validateLoginIntoCRMApp(String Un, String Pw) throws InterruptedException, IOException {

        txtUserName.sendKeys(Un);
        txtPassword.sendKeys(Pw);

        Thread.sleep(5000);
        driver.switchTo().frame("intercom-borderless-frame");

        Actions alret = new Actions(driver);
        //alret.moveToElement(driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/div[1]/div/div/span"))).build().perform();
       // alret.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-author-summary-name-from']//span[contains(text(),'CRMPRO')]"))).build().perform();

        alret.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']"))).build().perform();

        driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();

        screenshot.screenShot(driver,"loginPageone");

        //getLogs.logCapture();


        btnloginbtn.click();



        return new HomePage();


    }
}
