package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.executor.TestBasePage;
import com.backend.reports.Reporter;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class MyAccountPage extends TestBasePage {

	@FindBy(xpath = "//h1[contains(text(),'Hello')]")
	private WebElement HelloText;

	@FindBy(xpath = "//a[@class='topnav-cookware ']")
	private WebElement cookware;

	@FindBy(xpath = "//li[1]//a[contains(text(),'Tea Kettles')]")
	private WebElement teaKettle;

	public WebElement getCookware() {
		return cookware;
	}

	public WebElement getTeaKettle() {
		return teaKettle;
	}

	public WebElement getHelloText() {
		return HelloText;
	}

	public void waitForPageToLoad() {
		CommonUtils.webDriverWait(getHelloText(), 30);
	}

	public void selectTeaKettleFromCookware() {
		boolean status = (boolean) CommonUtils.performAction(getCookware(), ActionName.MOVE_TO_ELEMENT, null);
		if (status) {
			Reporter.logMessage("Successfully Hover on the Cookware");
		}
		boolean status1 = (boolean) CommonUtils.performAction(getTeaKettle(), ActionName.CLICK, null);
		if (status1) {
			Reporter.logMessage("Successfully clicked on the Tea Kettle Catagory");
		}
	}
}
