package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListenerToFailedTC;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

//this Listener to call once any Test is failed
@Listeners(CustomListenerToFailedTC.class)
public class TestLoginPage extends TestBase{



    LoginPage loginPage;
    HomePage homePage;

    Logger logger = Logger.getLogger(TestLoginPage.class);


    public TestLoginPage(){

        super(); //caling to supper class construction ie TestBase to call prop
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();  // call to initialization  method in TestBase class
        loginPage = new LoginPage(); //call to LogingPage class
    }

    @Test(priority = 1)
    public void validateLoginPageTitle(){

        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Freea CRM software in the cloud powers sales and customer service","Home page not found");

        logger.info("#################this is logign page Info#################");


    }

    @Test(priority = 2)
    public void crmLogoImgageTest(){

        Boolean crmImg =  loginPage.validateCRMImage();
        Assert.assertTrue(crmImg);
        //Assert.assertEquals(true,false);

    }
    @Test(priority = 3)
    public void validateLoginCRMHome() throws InterruptedException, IOException {
       // Thread.sleep(3000);
       homePage =  loginPage.validateLoginIntoCRMApp(prop.getProperty("username"),prop.getProperty("password"));

       logger.debug("@@@@@@@@@@@@this is usen name pw debug logs@@@@@@@@@@@@@@@");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
