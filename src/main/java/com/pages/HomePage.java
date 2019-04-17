package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class HomePage extends TestBasePage {

	@Override
	public void waitForPageToLoad() {
	}

	@FindBy(xpath = "//a[@class='user-account-link']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signIn;

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public void clickOnSignInLink() {
		CommonUtils.performAction(getMyAccount(), ActionName.MOVE_TO_ELEMENT, null);
		CommonUtils.performAction(signIn, ActionName.CLICK, null);
	}

}
