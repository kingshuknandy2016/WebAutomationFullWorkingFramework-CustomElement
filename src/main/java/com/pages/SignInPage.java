package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.backend.executor.TestBasePage;
import com.backend.executor.WebDriverManager;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class SignInPage extends TestBasePage {
	@FindBy(id = "login-email")
	private WebElement email;

	@FindBy(id = "login-password")
	private WebElement password;
	
	@FindBy(xpath="(//button[@id='btn-sign-in'])[2]")
	private WebElement signInBtn;

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}
	public void enterUsernamePassword(String username, String password) {

		try {
			CommonUtils.performAction(getEmail(), ActionName.SENDKEYS, username);
			CommonUtils.performAction(getPassword(), ActionName.SENDKEYS, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void userSignsIn() {

		try {
			CommonUtils.performAction(getSignInBtn(), ActionName.CLICK, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void waitForPageToLoad() {
	}
}
