package com.common.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.backend.executor.WebDriverManager;
import com.backend.reports.Reporter;

public class TestNgListners extends WebDriverManager implements ITestListener{

    @Override
    public void onStart(ITestContext iTestContext) {
    	System.err.println("=============Inside onStart=============");
    	Reporter.getReporter();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.err.println("==============Inside onFinish=============");
        Reporter.endReport();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    	System.err.println("==============Inside onTestStart=============");
    	Reporter.startParent(iTestResult.getMethod().getDescription(), "Scenario 1");
    	
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.err.println("===============Inside onTestSuccess=============");
        closeDriver();
        Reporter.endParent();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.err.println("===================Inside onTestFailure=============");
        closeDriver();
        Reporter.endParent();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.err.println("====================Inside onTestSkip=============");
        closeDriver();
        Reporter.endParent();
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}


}
