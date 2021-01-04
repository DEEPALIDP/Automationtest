package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchFlightPage {
	WebDriver driver;

	// locators
	By pagetitle = By.xpath("//span[@title='Cleartrip ']");
	By flight = By.xpath("//section[@id='Home']//a[@href='/flights']");
	By roundtrip = By.xpath("//input[@type='radio'][@id='RoundTrip']");
	By from = By.id("FromTag");
	By to = By.id("ToTag");
	By depart_date = By.id("DepartDate");
	By return_date = By.id("ReturnDate");
	By adults = By.xpath("//select[@name='adults']");
	By search_flight = By.id("SearchBtn");

	public SearchFlightPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// methods
	// click on Flights
	public void click_onFlights() {

		driver.findElement(flight).click();
	}

	// click on REount trip
	public void click_onRoundtrip() {
		driver.findElement(roundtrip).click();
	}

	// set from in textbox
	public void setFrom(String fromLocation) {

		driver.findElement(from).clear();
		driver.findElement(from).sendKeys(fromLocation);
	}
	/*
	 * public void setFrom() {
	 * 
	 * driver.findElement(from).clear(); driver.findElement(from); }
	 */

	// set destination textbox
	public void setTo(String tolocation) {
		driver.findElement(to).clear();
		driver.findElement(to).sendKeys(tolocation);
	}

	// set depart date
	public void setDepartDate(String date) {
		driver.findElement(depart_date).clear();
		driver.findElement(depart_date).sendKeys(date);
	}

	// set return date
	public void setReturnDate(String date) {
		driver.findElement(return_date).clear();
		driver.findElement(return_date).sendKeys(date);

	}

	// select Number of adults
	public void selectAdult(String adult) {
		Select select = new Select(driver.findElement(adults));
		select.selectByVisibleText(adult);

	}

	// click on sign in button
	public void click_OnSearchFlight() {
		driver.findElement(search_flight).click();
	}

	public void search(String fromLocation, String tolocation, String date, String date1)
	{
		if(!fromLocation.equals("")){
	     	this.setFrom(fromLocation);
		}
		this.setTo(tolocation);
		this.setDepartDate(date);
		this.setReturnDate(date1);

	}

}
