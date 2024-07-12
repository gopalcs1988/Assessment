package com.qa.test.pages;

import com.qa.test.core.BrowserInteractions;
import com.qa.test.utils.LocatorType;

public class SearchPage {

	static String depatureFlight = "(//div[@class='ng-star-inserted'])[1]//flight-card-new[1]//button[contains(text(),'Select')]";
	static String flightChoosenTick = "//div[contains(@class,'outbound--hold-tick')]";
	static String arrivalFlight = "(//div[@class='ng-star-inserted'])[2]//flight-card-new[1]//button[contains(text(),'Select')]";
	static String journeyWrapper = "//span[contains(@class,'journeys-wrapper__divisor')]";
	static String regularOption = "(//div[contains(@class,'fare-table__fare-column-border--regu')])[2]";
	static String loginLater = "//span[text()='Log in later']";
	static String clickTitlePassenger1 = "//span[contains(text(),'Passenger 1')]/../../..//div[contains(text(),'Title')]/following-sibling::div//button";
	static String clickMrPassenger1 = "//span[contains(text(),'Passenger 1')]/../../..//div[contains(text(),'Mr')]";
	static String firstNamePassenger1 = "//span[contains(text(),'Passenger 1')]/../../..//label[contains(text(),'First name')]/..//input";
	static String lastNamePassenger1 = "//span[contains(text(),'Passenger 1')]/../../..//label[contains(text(),'Last name')]/..//input";
	static String clickTitlePassenger2 = "//span[contains(text(),'Passenger 2')]/../../..//div[contains(text(),'Title')]/following-sibling::div//button";
	static String clickMrPassenger2 = "//span[contains(text(),'Passenger 2')]/../../..//div[contains(text(),'Mr')]";
	static String firstNamePassenger2 = "//span[contains(text(),'Passenger 2')]/../../..//label[contains(text(),'First name')]/..//input";
	static String lastNamePassenger2 = "//span[contains(text(),'Passenger 2')]/../../..//label[contains(text(),'Last name')]/..//input";
	static String continueButton = "//button[contains(text(),' Continue ')]";
	static String seatSection = "//div[contains(text(),'Our seat sections')]";
	
	
	public String chooseFlight() throws Exception {
		BrowserInteractions.click(LocatorType.XPATH, depatureFlight);
		BrowserInteractions.wait(1);
		BrowserInteractions.isVisible(LocatorType.XPATH, flightChoosenTick);
		BrowserInteractions.click(LocatorType.XPATH, arrivalFlight);
		BrowserInteractions.wait(1);
		BrowserInteractions.isVisible(LocatorType.XPATH, journeyWrapper);
		BrowserInteractions.click(LocatorType.XPATH, regularOption);
		BrowserInteractions.click(LocatorType.XPATH, loginLater);
		BrowserInteractions.isVisible(LocatorType.XPATH, clickTitlePassenger1);
		BrowserInteractions.click(LocatorType.XPATH, clickTitlePassenger1);
		BrowserInteractions.click(LocatorType.XPATH, clickMrPassenger1);
		BrowserInteractions.clearAndType(LocatorType.XPATH, firstNamePassenger1, "Raja");
		BrowserInteractions.clearAndType(LocatorType.XPATH, lastNamePassenger1, "Gopal");
		BrowserInteractions.isVisible(LocatorType.XPATH, clickTitlePassenger2);
		BrowserInteractions.click(LocatorType.XPATH, clickTitlePassenger2);
		BrowserInteractions.click(LocatorType.XPATH, clickMrPassenger2);
		BrowserInteractions.clearAndType(LocatorType.XPATH, firstNamePassenger2, "Rajagopal");
		BrowserInteractions.clearAndType(LocatorType.XPATH, lastNamePassenger2, "Arumugam");
		BrowserInteractions.click(LocatorType.XPATH, continueButton);
		return BrowserInteractions.getText(LocatorType.XPATH, seatSection);
	}

}
