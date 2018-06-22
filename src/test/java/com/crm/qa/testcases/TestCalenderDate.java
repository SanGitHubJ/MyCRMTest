package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListenerToFailedTC;
import com.crm.qa.util.RetryAnalyzer;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListenerToFailedTC.class)
public class TestCalenderDate extends TestBase {

    LoginPage loginPage;
    HomePage homepage;
    CalenderPage calPage;
    TestUtil util;
    RetryAnalyzer retry;

    public TestCalenderDate(){

        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        loginPage = new LoginPage();
        try {
            homepage = loginPage.validateLoginIntoCRMApp(prop.getProperty("username"), prop.getProperty("password"));
        }catch (IOException e){

            System.out.println("home page is not found");
        }
        calPage = new CalenderPage();

        util = new TestUtil();
        retry = new RetryAnalyzer();
    }

    //@Test(retryAnalyzer = com.crm.qa.util.RetryAnalyzer.class)
    @Test(priority = 1)
    public void validateDate() throws InterruptedException {

        util.switchToFrame();
        homepage.validateCalPage();

        Thread.sleep(4000);

        calPage.selectDate();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
