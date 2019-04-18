package com.tests;

import org.testng.annotations.Test;
import com.steps.BasicSteps;

public class BasicExecution {
	@Test(description = "A basic End to End Flow")
	public void BasicFlow() {
		BasicSteps.launch_Application_And_Navigate_To_SignInPage();;
		BasicSteps.enter_Username_Password_And_SignIn("kingshuknandy1990@gmail.com", "9007438097kingshuk");
		BasicSteps.select_TeaKettle_From_Cookware();
		BasicSteps.select_the_kettle("Breville Variable-Temperature Tea & Coffee Kettle");
		BasicSteps.add_item_to_cart();
		BasicSteps.click_on_checkOut();
		BasicSteps.click_on_saveforLater_and_Verify();
	}
}
