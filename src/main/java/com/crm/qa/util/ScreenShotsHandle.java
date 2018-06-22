package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotsHandle extends TestBase {

    //public WebDriver driver;

    //below method to get screenshots any test steps

//    public static void screenShot(WebDriver driver,String screenShotName) throws IOException {
//
//        TakesScreenshot st = (TakesScreenshot)driver;
//
//        File source =  st.getScreenshotAs(OutputType.FILE);
//
//        FileHandler.copy(source, new File("./screenShots/"+screenShotName+".jpg"));
//    }

    public void failedTC(String testMethodName) throws IOException {

        File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrfile,new File("/home/sanath/Workplace/Selenium/Intellij/MyCRMTest" +
//                "/screenShots/FailedScreenShots/"
//        +"failedshot_"+this.getClass().getName()+".jpg"));

        FileUtils.copyFile(scrfile,new File("/home/sanath/Workplace/Selenium/Intellij/MyCRMTest" +
                "/screenShots/FailedScreenShots/"
                +testMethodName+".jpg"));
    }

}
