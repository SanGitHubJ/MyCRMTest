package com.crm.qa.util;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTransformer implements IAnnotationTransformer { //try failed test cases in run time this is good method


    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(com.crm.qa.util.RetryAnalyzer.class);

    }
}
