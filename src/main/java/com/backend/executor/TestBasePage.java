package com.backend.executor;

import org.openqa.selenium.support.PageFactory;

public abstract class TestBasePage extends WebDriverManager {
	public abstract void waitForPageToLoad();

	public TestBasePage() {
		PageFactory.initElements(getDriver(), this);
		getDriver().manage().window().maximize();
	}
}
