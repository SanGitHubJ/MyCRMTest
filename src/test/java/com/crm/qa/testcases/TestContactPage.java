package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListenerToFailedTC;
import com.crm.qa.util.DataProviderExcel;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(CustomListenerToFailedTC.class)
public class TestContactPage extends TestBase {

    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;
    TestUtil util;
    DataProviderExcel exceldata;
    public TestContactPage(){

        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {

        initialization();
        loginPage = new LoginPage();
        homepage =  loginPage.validateLoginIntoCRMApp(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = new ContactsPage();
        util = new TestUtil();
        exceldata = new DataProviderExcel();
       // contactsPage = new ContactsPage();

    }
//
//        @Test(priority = 1)
//        public void validateCOntactPageName(){
//
//        homepage.validateContactPage();
//        Assert.assertTrue(contactsPage.validateContactPage());
//
//        }
//
//        @Test(priority = 2)
//        public void enterContactInfo(){
//
//        homepage.clickNewContactLink();
//
//        Assert.assertTrue(contactsPage.validateContactInfo());
//
//        }
    @DataProvider
    public Object[][] getCRMContacts() throws IOException {

       Object data [][] =  exceldata.getExcelTestData("Contacts");
       return data;
    }

        @Test(priority = 1, dataProvider = "getCRMContacts")
        public void enterContatsDetails(String title,String FN, String LN, String Cmp) throws InterruptedException, IOException {

        util.switchToFrame();
        homepage.clickNewContactLink();
        contactsPage.enterContactDeatils(title,FN,LN,Cmp);
        }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
