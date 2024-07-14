package com.qa.test.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.test.utils.TestCleanUp;

public class TestBase {
	public static WebDriver driver;

	public static void Initialization(String browser, String hubHost) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (browser.equalsIgnoreCase("Chrome")) {
//			 System.setProperty("webdriver.chrome.driver",
//			 "//Users//Chromedriver1//chromedriver");
//			 driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-running-insecure-content");
			capabilities.setBrowserName("chrome");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		} else {
			System.out.println("Input browser is not configured");
			System.exit(5);
		}
		String hubURL = "http://" + hubHost + ":4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), capabilities);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@BeforeSuite(alwaysRun = true)
	public void BeforeSuite() throws IOException {
		TestCleanUp.clearTempFolder();
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
