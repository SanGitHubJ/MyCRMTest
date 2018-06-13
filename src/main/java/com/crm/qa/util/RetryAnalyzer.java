package com.crm.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {  //this interface is to retry test cases in case failed in @Test Level

    int count =0;
    int reTryLimit= 3;

    public boolean retry(ITestResult result){

        if(count<reTryLimit){

            count++;
            return true;
        }
        return false;
    }


}
