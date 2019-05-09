package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.backend.elements.CusWebElement;
import com.backend.elements.ElementFactory;

public class HomePage {
	private WebDriver driver;

    @FindBy(xpath = "//a[@class='user-account-link']")
    CusWebElement signInLink;


    public static HomePage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, HomePage.class);
    }

}
