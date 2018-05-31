package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

    //static varibale can use any where
    //declar implecilty and page load time in case t0change value

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 30;

    public void switchToFrame(){

        driver.switchTo().frame("mainpanel");
    }

//    public void switchToFrame1(){
//
//        driver.switchTo().frame("mainpanel");
//    }

}
