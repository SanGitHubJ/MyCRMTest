package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestHomePage extends TestBase {

    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;
    TestUtil util;

    public TestHomePage(){

        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        loginPage = new LoginPage();
       homepage =  loginPage.validateLoginIntoCRMApp(prop.getProperty("username"),prop.getProperty("password"));
      contactsPage = new ContactsPage();
        util = new TestUtil();
    }

    @Test(priority = 1)
    public void validateHomePageTitle(){
        String hTitle = homepage.validateHomePageTitle();
        Assert.assertEquals(hTitle,"CRMPRO","Home page title not fpound");
    }

    @Test(priority = 2)
    public void validaetHomePageUName(){

            util.switchToFrame();
        Assert.assertTrue(homepage.validateHomePageUser());
    }

    @Test(priority = 3)
    public void validaetContactPage() throws InterruptedException {

        //Thread.sleep(3000);
       // util.switchToFrame1();

       contactsPage = homepage.validateContactPage();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
