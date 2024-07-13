package com.qa.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.qa.test.core.BrowserInteractions;
import com.qa.test.utils.LocatorType;

public class HomePage {

	WebElement privacyMessage = null;
	static final String depature = "//input[@id='input-button__departure']";
	static final String depatureLocation = "Dublin";
	static final String destination = "//input[@id='input-button__destination']";
	static final String destinationLocation = "Barcelona";
	static final String chooseDestination = "//span[normalize-space(text())='Barcelona (All Airports)']";
	static final String fligtsOption = "//div[@class='tab-text ng-star-inserted' and text()='flights']";
	static final String roundTrip = "//span[text()='Return trip']";
	static final String privacyMessagePopup = "//p[contains(text(),'We value your privacy')]";
	static final String acceptPrivacyMessage = "//button[contains(text(),'Yes')]";
	static final String chooseDate = "//div[@data-ref='input-button__dates-from']//div[contains(text(),' Choose date ')]";
	static final String novMonth = "//div[@class='m-toggle__month' and contains(text(),'Nov')]";
	static final String novCalendar = "//div[contains(text(),' November 2024')]";
	static final String depatureDate = "//div[contains(text(),' November 2024')]/..//div[@data-id='2024-11-26']";
	static final String returnDate = "//div[contains(text(),' December 2024')]/..//div[@data-id='2024-12-31']";
	static final String passengersSelection = "//div[contains(@class,'passengers-picker') and text()='Adults']";
	static final String adultIncrement = "//div[contains(@class,'passengers-picker') and text()='Adults']/../following-sibling::div//div[contains(@class,'counter__button-wrapper--enabled')]";
	static final String adultCount = "//div[contains(@class,'passengers-picker') and text()='Adults']/../following-sibling::div//div[contains(@class,'counter__value')]";
	static final String searchButton = "//span[text()='Search']";

	public String searchFlights() throws Exception {

		try {
			BrowserInteractions.waitForElementPresence(By.xpath(privacyMessagePopup));
			BrowserInteractions.click(LocatorType.XPATH, acceptPrivacyMessage);
		} catch (NoSuchElementException e) {
			System.out.println("Privacy message not found" + e.getMessage());
		}
		BrowserInteractions.click(LocatorType.XPATH, fligtsOption);
		BrowserInteractions.isElementPresent(LocatorType.XPATH, roundTrip);
		BrowserInteractions.click(LocatorType.XPATH, roundTrip);
		BrowserInteractions.clearAndType(LocatorType.XPATH, depature, depatureLocation);
		BrowserInteractions.clearAndType(LocatorType.XPATH, destination, destinationLocation);
		BrowserInteractions.wait(2);
		BrowserInteractions.click(LocatorType.XPATH, chooseDestination);
		BrowserInteractions.wait(2);
		BrowserInteractions.isVisible(LocatorType.XPATH, chooseDate);
		BrowserInteractions.click(LocatorType.XPATH, novMonth);
		BrowserInteractions.isVisible(LocatorType.XPATH, novCalendar);
		BrowserInteractions.click(LocatorType.XPATH, depatureDate);
		BrowserInteractions.click(LocatorType.XPATH, returnDate);
		BrowserInteractions.isVisible(LocatorType.XPATH, passengersSelection);
		BrowserInteractions.wait(1);
		BrowserInteractions.click(LocatorType.XPATH, adultIncrement);
		String adultValue = BrowserInteractions.getText(LocatorType.XPATH, adultCount);
		BrowserInteractions.click(LocatorType.XPATH, searchButton);
		return adultValue;
	}
}
