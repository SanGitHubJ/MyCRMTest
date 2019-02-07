package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.crm.qa.util.TestUtil;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    //construction is same as the class name
    public TestBase(){

        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src\\main\\java\\com\\crm\\qa\\config\\config.properties");

            prop.load(ip);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void initialization() throws InterruptedException {


            String browserName = prop.getProperty("browser");
            //try{

            if (browserName.equals("chrome")) {

                String driverlocation = "D:\\EFuture\\Sanath\\Projects\\Automation\\SeleniumNew\\chromedriver.exe";
                File driverPath = new File(driverlocation);
                System.setProperty("webdriver.chrome.driver", driverPath.toString());
                //System.setProperty("webdriver.chrome.driver","E:\\Sanath\\SelleniumNew\\MyProjects\\src\\main\\java\\com\\crm\\qa\\config\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equals("FireFox")) {

                String driverlocation = "D:\EFuture\Sanath\Projects\Automation\SeleniumNew\chromedriver.exe";
                File driverPath = new File(driverlocation);
                System.setProperty("webdriver.gecko.driver", driverPath.toString());
                driver = new FirefoxDriver();
            }
            // Thread.sleep(2000);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));
//        }catch(InterruptedException e){
//
//            System.out.print("Not intialize");
//
//        }
    }


}
