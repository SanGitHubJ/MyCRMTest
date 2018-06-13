package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotsHandle extends TestBase {

    //public WebDriver driver;

    public static void screenShot(WebDriver driver,String screenShotName) throws IOException {

        TakesScreenshot st = (TakesScreenshot)driver;

        File source =  st.getScreenshotAs(OutputType.FILE);

        FileHandler.copy(source, new File("./screenShots/"+screenShotName+".jpg"));
    }

}
