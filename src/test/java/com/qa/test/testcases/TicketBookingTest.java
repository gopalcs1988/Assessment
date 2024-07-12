package com.qa.test.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.test.base.TestBase;

public class TicketBookingTest extends TestBase{
	
	@Parameters({ "browser", "hub_host" })
	@BeforeClass
	public void setup(String browser, String host) throws MalformedURLException {
		Initialization(browser, host);
	}
	
	@Test
	public void test() {
		System.out.println("Testing");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
