package com.qa.test.pages;

import com.qa.test.core.BrowserInteractions;
import com.qa.test.utils.LocatorType;

public class SeatSelection {
	
	static String getAvailableSeats = "//div[@class='seatmap__extraleg ng-star-inserted']//button[contains(@class,'seatmap__seat seatmap__seat')]";
	static String occupiedSeats = "//div[contains(@class,'seat__seat--occupied')]";
	static String nextFlight = "//button[contains(text(),' Next flight ')]";
	static String pickTheseSeats = "//button[contains(text(),' Pick these seats ')]";
	static String fastTrack = "//h2[contains(text(),' Skip long security queues with Fast Track ')]";
	static String skipFastTrack = "//button[contains(text(),'No, thanks')]";
	static String checkBaggagePage = "//h3[contains(text(),'Cabin Baggage Allowance')]";
	
	public String selectSeat() throws Exception {
		chooseSeat();
		BrowserInteractions.click(LocatorType.XPATH, nextFlight);
		BrowserInteractions.wait(3);
		if(BrowserInteractions.isElementPresent(LocatorType.XPATH, pickTheseSeats)) {
			BrowserInteractions.click(LocatorType.XPATH, pickTheseSeats);
			Thread.sleep(5000);
			int occupiedSeatsCount = BrowserInteractions.getCount(LocatorType.XPATH, occupiedSeats);
			System.out.println(occupiedSeatsCount);
			if(occupiedSeatsCount < 2 ) {
				throw new Exception("The number of occupied seats does not match the expected count of 2.");
		    }
		}
		else 
		{
			chooseSeat();
		}
		BrowserInteractions.isVisible(LocatorType.XPATH, fastTrack);
		BrowserInteractions.click(LocatorType.XPATH, skipFastTrack);
		
		return BrowserInteractions.getText(LocatorType.XPATH, checkBaggagePage);
	}
	
	public static void chooseSeat() throws Exception {
		int count = BrowserInteractions.getCount(LocatorType.XPATH, getAvailableSeats);
		if (count >= 2) {
			BrowserInteractions.click(LocatorType.XPATH, "(//div[@class='seatmap__extraleg ng-star-inserted']//button[contains(@class,'seatmap__seat seatmap__seat')])[1]");
			BrowserInteractions.click(LocatorType.XPATH, "(//div[@class='seatmap__extraleg ng-star-inserted']//button[contains(@class,'seatmap__seat seatmap__seat')])[2]");
		}
		else {
	        throw new Exception("Not enough available seats to select.");
	    }
		int occupiedSeatsCount = BrowserInteractions.getCount(LocatorType.XPATH, occupiedSeats);
		if(occupiedSeatsCount != 2) {
			throw new Exception("The number of occupied seats does not match the expected count of 2.");
	    }
	}

}
