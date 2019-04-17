package com.pages;

import com.backend.executor.TestBasePage;
import com.backend.utils.ActionName;
import com.backend.utils.CommonUtils;

public class TeaKettelsPage extends TestBasePage {

	@Override
	public void waitForPageToLoad() {
	}
	
	public void selectTheProduct(String ProductName){
		try {
			CommonUtils.performAction(CommonUtils.getElement("//a[contains(text(),'%s')]", ProductName),ActionName.CLICK,null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
