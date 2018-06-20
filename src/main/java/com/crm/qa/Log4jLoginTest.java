//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.File;
//
//public class Log4jLoginTest {
//
//    WebDriver driver;
//
//    Logger log = Logger.getLogger(Log4jLoginTest.class);
//
//    @BeforeMethod
//    public void setUp(){
//
//        String driverlocation = "/home/sanath/Applications/Drivers/chromedriver";
//        File driverPath = new File(driverlocation);
//        System.setProperty("webdriver.chrome.driver", driverPath.toString());
//
//        driver = new ChromeDriver();
//
//        driver.get("https://www.freecrm.com");
//        log.info("loging crm test logsssss");
//    }
//
//    @Test(priority = 1)
//    public void getitle(){
//
//        String x = driver.getTitle();
//
//        System.out.println(x);
//        Assert.assertEquals(x,"Free CRM software in the cloud powers sales and customer service");
//        log.debug("this is for debug");
//        log.warn("thisi is waring");
//        log.fatal("this is for fatal");
//
//    }
//    @Test(priority = 2)
//    public void getlogo(){
//
//       boolean t = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
//       Assert.assertTrue(t);
//
//    }
//
//
//    @AfterMethod
//    public void tearDown(){
//
//        driver.quit();
//    }
//}
