package com.backend.executor;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.backend.reports.Reporter;
import com.backend.utils.ConfigurationManager;
import com.relevantcodes.extentreports.LogStatus;

public class WebDriverManager {
	private static WebDriver driver = null;
	private static DriverType driverType;
	private static String url;

	public static WebDriver initializeDriver() {
		try {
			driverType = DriverConfig.getDriverType();
			url = DriverConfig.getEnvUrl();
			switch (driverType) {
			case FIREFOX:
				System.setProperty("webdriver.firefox.driver", ConfigurationManager.getBundle().getProperties("")
						.toString());
				driver = new FirefoxDriver();
				driver.get(url);
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
			case ANDROID:
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "65e9e0450803");
				capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.automationtest");
				capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.automationtest.MainActivity");
				try {
					driver = new AndroidDriver(new URL(url), capabilities);
				} catch (Exception e) {
					
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			Reporter.logChildStatus(LogStatus.FAIL, "Exception occured while initializing driver. Exception:"+e.getLocalizedMessage());
		}
		
		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = initializeDriver();
			System.out.println("=========Driver Initialization successfully Done==============");
		}
		return driver;
	}

	public static AndroidDriver getAndroidDriver() {
		if (getDriver() instanceof AndroidDriver) {
			return (AndroidDriver) getDriver();
		} else {
			return null;
		}
	}

	public static IOSDriver getIOSDriver() {
		if (getDriver() instanceof IOSDriver) {
			return (IOSDriver) getDriver();
		} else {
			return null;
		}
	}
	
	public static AppiumDriver getAppiumDriver() {
		if (getDriver() instanceof AppiumDriver) {
			return (AppiumDriver) getDriver();
		} else {
			return null;
		}
	}
	
	public static MobileDriver getMobileDriver() {
		if (getDriver() instanceof MobileDriver) {
			return (MobileDriver) getDriver();
		} else {
			return null;
		}
	}

	public static void closeDriver() {
		driver.close();
		driver.quit();
		driver=null;
	}

	public static void pause(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
		}
	}
}
