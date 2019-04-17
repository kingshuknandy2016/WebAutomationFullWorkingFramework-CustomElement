package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class CartModal extends TestBasePage {

	@Override
	public void waitForPageToLoad() {
	}
	
	@FindBy(xpath="//a[@id='anchor-btn-checkout']")
	private WebElement chkOutbtn;

	public WebElement getChkOutbtn() {
		return chkOutbtn;
	}
	
	public void clickOnCheckout(){
		CommonUtils.performAction(getChkOutbtn(), ActionName.CLICK, null);
	}

}
