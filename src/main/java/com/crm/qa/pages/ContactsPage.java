package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
//import com.crm.qa.util.CaptureLogs;
import com.crm.qa.util.ScreenShotsHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class ContactsPage extends TestBase {

    ScreenShotsHandle screenshot = new ScreenShotsHandle();
    //CaptureLogs getLogs = new CaptureLogs();

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement lblContacts;

    @FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
    WebElement lblContInfo;


   @FindBy(id = "first_name")
    WebElement txtFistName;


    @FindBy(id = "middle_initial")
    WebElement txtmiddle_initial;

    @FindBy(id = "surname")
    WebElement txtsurname;

    @FindBy(xpath = "//input[@type='text' and @name='client_lookup']")
    WebElement txtCompany;


    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement btnSave;

    public ContactsPage(){

        PageFactory.initElements(driver,this);
    }

    public boolean validateContactInfo(){

            return lblContInfo.isDisplayed();

    }

    public boolean validateContactPage(){

        return lblContInfo.isDisplayed();

    }

    public void enterContactDeatils(String title,String FN, String SN, String CM) throws InterruptedException, IOException {


        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        txtFistName.sendKeys(FN);
        txtsurname.sendKeys(SN);
        txtCompany.sendKeys(CM);
        btnSave.click();
        Thread.sleep(4000);

       // screenshot.screenShot(driver,"contactPage");

      //  getLogs.logCapture();
    }


}
