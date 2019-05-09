package com.pages;

import org.openqa.selenium.support.FindBy;

import com.backend.elements.CusWebElement;
import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class CartModal extends TestBasePage {

	@Override
	public void waitForPageToLoad() {
	}
	
	@FindBy(xpath="//a[@id='anchor-btn-checkout']")
	private CusWebElement chkOutbtn;

	public CusWebElement getChkOutbtn() {
		return chkOutbtn;
	}
	
	public void clickOnCheckout(){
		CommonUtils.performAction(getChkOutbtn(), ActionName.CLICK, null);
	}

}
