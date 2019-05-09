package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.elements.CusWebElement;
import com.backend.executor.TestBasePage;
import com.backend.reports.Reporter;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class MyAccountPage extends TestBasePage {

	@FindBy(xpath = "//h1[contains(text(),'Hello')]")
	private CusWebElement HelloText;

	@FindBy(xpath = "//a[@class='topnav-cookware ']")
	private CusWebElement cookware;

	@FindBy(xpath = "//li[1]//a[contains(text(),'Tea Kettles')]")
	private CusWebElement teaKettle;

	public CusWebElement getCookware() {
		return cookware;
	}

	public CusWebElement getTeaKettle() {
		return teaKettle;
	}

	public CusWebElement getHelloText() {
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
