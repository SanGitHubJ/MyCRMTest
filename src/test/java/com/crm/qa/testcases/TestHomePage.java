package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestHomePage extends TestBase {

    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;
    TestUtil util;

    SoftAssert softAssert = new SoftAssert();

    public TestHomePage(){

        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {

        initialization();
        loginPage = new LoginPage();
       homepage =  loginPage.validateLoginIntoCRMApp(prop.getProperty("username"),prop.getProperty("password"));
      contactsPage = new ContactsPage();
        util = new TestUtil();
    }

    @Test(priority = 1)
    public void validateHomePageTitle(){
        String hTitle = homepage.validateHomePageTitle();

        //hard assersion won't exucute subcequently test case if prior TC are failed.
       // Assert.assertEquals(hTitle,"CRMPROt","Home page title not fpound");

        //soft assersion, will run subcequent test  cases in same test eventhough prior TC failed.
        softAssert.assertEquals(hTitle,"CRMPROt","Home page title not fpound");

        System.out.println("to check hard asserston");

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validaetHomePageUName(){

            util.switchToFrame();
        Assert.assertTrue(homepage.validateHomePageUser());

        System.out.println("to check hard asserston should run bxc in seperate Test");
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
