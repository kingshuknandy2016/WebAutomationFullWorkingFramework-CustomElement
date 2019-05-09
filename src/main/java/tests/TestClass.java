package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

	static WebDriver driver;
    static HomePage homePage;
    
    @BeforeTest
    public static void beforeClass(){
    	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
         
    	driver = new ChromeDriver();
    	driver.get("https://www.williams-sonoma.com/");
        homePage = HomePage.initialize(driver);
       // homePage.get();
    }
    
    @Test
    public void tests() throws InterruptedException{
    	homePage.signInLink.click();
    	Thread.sleep(30000);
    }
}
