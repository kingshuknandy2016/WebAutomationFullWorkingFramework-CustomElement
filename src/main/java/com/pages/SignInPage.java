package com.pages;

import org.openqa.selenium.support.FindBy;
import com.backend.elements.CusWebElement;
import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class SignInPage extends TestBasePage {
	@FindBy(id = "login-email")
	private CusWebElement email;

	@FindBy(id = "login-password")
	private CusWebElement password;
	
	@FindBy(xpath="(//button[@id='btn-sign-in'])[2]")
	private CusWebElement signInBtn;

	public CusWebElement getSignInBtn() {
		return signInBtn;
	}

	public CusWebElement getEmail() {
		return email;
	}

	public CusWebElement getPassword() {
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
