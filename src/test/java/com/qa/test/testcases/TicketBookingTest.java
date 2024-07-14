package com.qa.test.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.test.base.TestBase;
import com.qa.test.core.BrowserInteractions;
import com.qa.test.pages.HomePage;
import com.qa.test.pages.SearchPage;
import com.qa.test.pages.SeatSelection;

import org.testng.Assert;

public class TicketBookingTest extends TestBase {

	HomePage homePage = new HomePage();
	SearchPage searchPage = new SearchPage();
	SeatSelection chooseSeat = new SeatSelection();

	@Parameters({ "browser","hub_host" })
	@BeforeClass
	public void setup(String browser, String hub_host) throws MalformedURLException {
		Initialization(browser, hub_host);
	}

	@Test
	public void FlightTicketBooking() throws Exception {
		BrowserInteractions.navigateToURL("https://www.ryanair.com/");
		Assert.assertEquals("2", homePage.searchFlights(), "Adult count is not as expected.");
		Assert.assertEquals("Our seat sections", searchPage.chooseFlight(), "Seat sections page is not landed");
		Assert.assertEquals("Cabin Baggage Allowance", chooseSeat.selectSeat());
		
	}

}
