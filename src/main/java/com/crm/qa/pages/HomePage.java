package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath = "//td[@class='headertext' and contains(text(),'User: test test')]")
    WebElement lblUserName;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement lnkContact;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement lnkNewContact;

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    public String validateHomePageTitle(){

        return driver.getTitle();
    }

    public boolean validateHomePageUser(){

        return lblUserName.isDisplayed();

    }

    public ContactsPage validateContactPage(){

        lnkContact.click();
        return new ContactsPage();
    }

    public void clickNewContactLink(){

        Actions action = new Actions(driver);
        action.moveToElement(lnkContact).build().perform();
        lnkNewContact.click();
    }

}
