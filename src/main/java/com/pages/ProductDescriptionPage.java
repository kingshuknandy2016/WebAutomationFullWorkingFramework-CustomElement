package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class ProductDescriptionPage extends TestBasePage {
	
	@FindBy(xpath="//button[@id='primaryGroup_addToCart_0']")
	private WebElement addToCartbtn;
	

	public WebElement getAddToCartbtn() {
		return addToCartbtn;
	}

	@Override
	public void waitForPageToLoad() {

	}
	
	public void addItemToCart(){
		CommonUtils.performAction(getAddToCartbtn(), ActionName.CLICK, null);
	}

}
