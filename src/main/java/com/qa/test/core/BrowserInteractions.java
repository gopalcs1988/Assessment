package com.qa.test.core;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.test.base.TestBase;
import com.qa.test.utils.LocatorType;

public class BrowserInteractions extends TestBase {

	public static WebElement element;
	public static WebDriverWait wait;

	public static WebElement getElement(LocatorType locatorType, String locator) throws Exception {

		By by;
		switch (locatorType) {
		case XPATH:
			by = By.xpath(locator);
			break;
		case ID:
			by = By.id(locator);
			break;
		case CSSSELECTOR:
			by = By.cssSelector(locator);
			break;
		case NAME:
			by = By.name(locator);
			break;
		case CLASSNAME:
			by = By.className(locator);
			break;
		case LINKTEXT:
			by = By.linkText(locator);
			break;
		case PARTIALLINKTEXT:
			by = By.partialLinkText(locator);
			break;
		case TAGNAME:
			by = By.tagName(locator);
			break;
		default:
			throw new Exception("Unknown locator type");
		}

		try {
			element = waitForElementPresence(by);

		} catch (Exception e) {
			throw new Exception("Element not visible in the page" + " with locator: " + locator + " Type used:"
					+ locatorType.name());

		}
		return element;
	}

	public static WebElement waitForElementPresence(final By by) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void navigateToURL(String url) {
		driver.get(url);
	}

	public static void click(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.click();
	}

	public static void clearAndType(LocatorType type, String selector, String value) throws Exception {
		element = getElement(type, selector);
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public static void isVisible(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.isDisplayed();
	}
	public static void isEnabled(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.isEnabled();
	}

	public static String getText(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		String text = element.getText();
		return text;
	}
	
	public static boolean isElementPresent(LocatorType type, String selector) throws Exception {
		try {
			element = getElement(type, selector);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static void keyPressEnter(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.sendKeys(Keys.ENTER);
	}
	
	public static void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static int getCount(LocatorType type, String selector) throws Exception {
		int attempts = 0;
	    int maxAttempts = 3;
	    while (attempts < maxAttempts) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            List<WebElement> seats = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(selector)));
	            return seats.size();
	        } catch (StaleElementReferenceException e) {
	            attempts++;
	            if (attempts == maxAttempts) {
	                throw e;
	            }
	        }
	    }
	    return 0;
	}

}
