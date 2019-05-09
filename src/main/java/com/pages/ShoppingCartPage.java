package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backend.elements.CusWebElement;
import com.backend.executor.TestBasePage;
import com.backend.reports.Reporter;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingCartPage extends TestBasePage {

	@Override
	public void waitForPageToLoad() {	
	}
	
	@FindBy(xpath="//a[contains(text(),'Save For Later')]")
	private CusWebElement saveForLater;
	
	@FindBy(xpath="")
	private CusWebElement remove ;
	
	@FindBy(xpath="//div[@id='empty-cart']//p[@class='save-for-later-message']")
	private CusWebElement itemSavedMsg ;

	public CusWebElement getItemSavedMsg() {
		return itemSavedMsg;
	}

	public CusWebElement getSaveForLater() {
		return saveForLater;
	}

	public CusWebElement getRemove() {
		return remove;
	}
	
	public void clickOnSaveForLater(){
		CommonUtils.performAction(getSaveForLater(), ActionName.CLICK, null);
	}
	
	public void verifySaveMessage(){
		String msg=(String) CommonUtils.performAction(getItemSavedMsg(), ActionName.GET_TEXT, null);
		if(msg.contains("1 saved item")){
			System.out.println("Item is saved");
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Verified that the item is saved");
		}
	}

}
