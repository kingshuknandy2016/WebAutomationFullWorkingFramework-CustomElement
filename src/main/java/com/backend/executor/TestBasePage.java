package com.backend.executor;

import org.openqa.selenium.support.PageFactory;

import com.backend.elements.ElementFactory;

public abstract class TestBasePage extends WebDriverManager {
	public abstract void waitForPageToLoad();

	public TestBasePage() {
		ElementFactory.initElements(getDriver(), this);
		getDriver().manage().window().maximize();
	}
}
