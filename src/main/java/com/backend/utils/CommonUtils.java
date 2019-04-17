package com.backend.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.backend.executor.WebDriverManager;
import com.backend.reports.Reporter;
import com.relevantcodes.extentreports.LogStatus;

public class CommonUtils extends WebDriverManager {
	
	public static void webDriverWait(WebElement element,long timeSecs){
		WebDriverWait wait = new WebDriverWait(getDriver(), timeSecs);
		element = wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Object performAction(WebElement element, ActionName name, Object value){
		try {
		Actions actionbuilder = new Actions(getDriver());
		if (isPresent(getDriver().findElements(By.xpath("//a[@title='Minimize']")))) {
			System.out.println("*********************popup is present****************************");
			actionbuilder.sendKeys(Keys.ESCAPE).perform();
			Thread.sleep(200);
			if (isPresent(getDriver().findElements(By.xpath("(//a[@title='Close'])[3]")))) {
				getDriver().findElement(By.xpath("(//a[@title='Close'])[3]")).click();
			}
			Thread.sleep(3000);
		}
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		
			switch (name) {
			case CLICK:
				element.click();

				break;
			case CLICKACTION:
				actionbuilder.moveToElement(element).doubleClick().build().perform();

				break;
			case ESCAPE:
				actionbuilder.sendKeys(Keys.ESCAPE).perform();

				break;
			case MOVE_TO_ELEMENT:
				actionbuilder.moveToElement(element).build().perform();

				break;
			case SENDKEYS:
				element.sendKeys(value.toString());

				break;
			case GET_TEXT:
				return element.getText();
			}
			System.out.println(name + " Action Successfully Performed on the element");
			return true;
		} catch (Exception e) {
			System.out.println("Exception Occured:" + e.getLocalizedMessage());
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
			return false;
		}
		
	}

	public static void elementStatusFinder(WebElement element) {
		System.out.println("=====================================");
		System.out.println("Element:" + element.getAttribute("innerHTML"));
		System.out.println("Displayed:" + element.isDisplayed());
		System.out.println("Enabled:" + element.isEnabled());
		System.out.println("Selected:" + element.isSelected());
		System.out.println("=====================================");
	}

	public static boolean isPresent(List<WebElement> elementList) {
		if (elementList.size() == 0) {
			return false;
		} else
			return true;
	}
	
	public static WebElement getElement(String locator,String value){
		return getDriver().findElement(By.xpath(String.format(locator, value)));
	}
	
	public static String getStepName() {
		String name=new Throwable().getStackTrace()[1].getMethodName();
		return name;
	}
}
