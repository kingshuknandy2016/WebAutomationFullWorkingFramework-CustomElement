package com.backend.reports;

import java.util.ArrayList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.backend.executor.WebDriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	static ExtentReports extent;
	static ExtentTest parent;
	static ExtentTest child;
	static ArrayList<ExtentTest> childArray;
	
	public static void getReporter() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\Reports\\Results.html", true);
		}
	}
	
	public static void startParent(String testName,String description){
		parent=extent.startTest(testName, description);
		childArray=new ArrayList<ExtentTest>();
	}
	
	public static void startStep(String stepName,String stepDescription){
		
		child=extent.startTest(stepName, stepDescription);
	}
	
	public static void logChildStatus(LogStatus status,String description){
		child.log(status, description);
	}
	
	public static void logParentStatus(LogStatus status,String description){
		parent.log(status, description);
	}
	public static void logMessage(String description){
		child.log(LogStatus.INFO, description);
	}
	public static void logChildStatusWithScreenShots(LogStatus logStatus,String desString){
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot) WebDriverManager.getDriver()).
                getScreenshotAs(OutputType.BASE64);
        child.log(logStatus, desString+child.addBase64ScreenShot(base64Screenshot));
	}
	
	public static void logParentStatusWithScreenShots(LogStatus logStatus,String desString){
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot) WebDriverManager.getDriver()).
                getScreenshotAs(OutputType.BASE64);
        parent.log(logStatus, desString+child.addBase64ScreenShot(base64Screenshot));
	}
	public static void endStep(){
		extent.endTest(child);
		childArray.add(child);
	}
	
	public static void endParent(){
		for (ExtentTest test:childArray) {
			parent.appendChild(test);
		}
		extent.endTest(parent);
	}
	
	public static void endReport(){
		extent.flush();
	}
	
	public static void main(String[] args) {

		getReporter();
		startParent("1st Scenario", "Scenario 1");
		startStep("StepA", "");
		//logStatus(LogStatus.PASS, "");
		logMessage("Hi I am");
		logMessage("I want to go");
		endStep();
		startStep("StepB", "");
		logChildStatus(LogStatus.PASS, "");
		endStep();
		startStep("StepC", "");
		logChildStatus(LogStatus.PASS, "");
		endStep();
		endParent();
		
		startParent("1st Scenario", "Scenario 1");
		endParent();
		endReport();
	}
}
