package com.WebAutomation;

import org.testng.annotations.Test;

import com.utilities.BaseClass;

import pageObjects.FlightBookingPage;

public class TestCase1 extends BaseClass {

	@Test
	public void loginPage() throws InterruptedException {
		FlightBookingPage flight = new FlightBookingPage();
		flight.autoSuggestiveDropdwn();
		flight.selectChkBox();
		flight.dynamicDropDwnFromTo();
		flight.dropDwnSelectPassenger();
		
//		https://rahulshettyacademy.com/client
		
	}
	
	
}
