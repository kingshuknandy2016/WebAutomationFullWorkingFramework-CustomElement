package com.steps;

import com.backend.reports.Reporter;
import com.backend.utils.CommonUtils;
import com.pages.CartModal;
import com.pages.HomePage;
import com.pages.MyAccountPage;
import com.pages.ProductDescriptionPage;
import com.pages.ShoppingCartPage;
import com.pages.SignInPage;
import com.pages.TeaKettelsPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicSteps {
	public static HomePage homePage;
	public static SignInPage signInPage;
	public static MyAccountPage accountPage;
	public static TeaKettelsPage kettle;
	public static ProductDescriptionPage PDP;
	public static CartModal cartModal;
	public static ShoppingCartPage shoppingCartPage;

	@Given("^Launch Application and Navigate to sign-In page$")
	public static void launch_Application_And_Navigate_To_SignInPage() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Launch Application and Navigate To sign In Page");
			homePage = new HomePage();
			homePage.clickOnSignInLink();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS,
					"Launched the Application and Successfully navigated to Sign In page");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

	public static void TestFormat() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Description");
			// Write Code Here
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and clicks on signIn$")
	public static void enter_Username_Password_And_SignIn(String username, String Password) {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "User enters username and password and Clicks sign In");
			signInPage = new SignInPage();
			signInPage.enterUsernamePassword(username, Password);
			signInPage.userSignsIn();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "User successfully signs in");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

	@When("^User selects Tea Kettle from CookWare$")
	public static void select_TeaKettle_From_Cookware() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Hover on Cookware and click on Tea Kettle");
			accountPage = new MyAccountPage();
			accountPage.waitForPageToLoad();
			accountPage.selectTeaKettleFromCookware();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Successfully Clicked on Tea Kettle Catagory");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

	@When("^User selects Kettle \"([^\"]*)\"$")
	public static void select_the_kettle(String kettlename) {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Select a Kettle ");
			kettle = new TeaKettelsPage();
			kettle.selectTheProduct(kettlename);
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Successfully selected the Kettle with name "
					+ kettlename);
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}

	}

	@When("^User add the items to cart$")
	public static void add_item_to_cart() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Add the item to cart");
			ProductDescriptionPage PDP = new ProductDescriptionPage();
			PDP.addItemToCart();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Successfully added the item into cart");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

	@When("^User clicks on check out$")
	public static void click_on_checkOut() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Click on Checkout");
			cartModal = new CartModal();
			cartModal.clickOnCheckout();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Successfully Clicked on checkout");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}

	}

	@Then("^User clicks on save for later and verify the item is saved$")
	public static void click_on_saveforLater_and_Verify() {
		try {
			Reporter.startStep(CommonUtils.getStepName(), "Click on saved for Later");
			shoppingCartPage = new ShoppingCartPage();
			shoppingCartPage.clickOnSaveForLater();
			shoppingCartPage.verifySaveMessage();
			Reporter.logChildStatusWithScreenShots(LogStatus.PASS, "Successfully clicked on Save for Later");
			Reporter.endStep();
		} catch (Exception e) {
			Reporter.logChildStatusWithScreenShots(LogStatus.FAIL, "Exception Occured:" + e.getLocalizedMessage());
		}
	}

}
