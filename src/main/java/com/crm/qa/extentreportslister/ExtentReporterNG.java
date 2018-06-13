package com.crm.qa.extentreportslister;

import com.relevantcodes.extentreports.*;


import com.relevantcodes.extentreports.model.Test;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Date;

public abstract class ExtentReporterNG implements IReporter {


    private ExtentReports extent;

     public void generateReports(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
    //public void generateReports(List<ISuite> suites,String outputDirectory){

        extent = new ExtentReports(outputDirectory+ File.separator+"Extent.html",true);

        for(ISuite suite:suites){

            Map<String,ISuiteResult> result = suite.getResults();

            for(ISuiteResult r : result.values()){
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(),LogStatus.PASS);
                buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
            }
        }
        extent.flush();
        extent.close();
    }

    public void buildTestNodes(IResultMap tests, LogStatus status){

        ExtentTest test;

        if(tests.size()>0){
            for(ITestResult result: tests.getAllResults()){
                test=extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for(String group: result.getMethod().getGroups())
                    test.assignCategory(group);

                    if(result.getThrowable() !=null){
                        test.log(status, result.getThrowable());
                    }else{
                        test.log(status,"Test" + status.toString().toLowerCase() + "ed");
                    }
                    extent.endTest(test);

            }
        }
    }

    private Date getTime(long millies){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millies);
        return calendar.getTime();

    }

}
