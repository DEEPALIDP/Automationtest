package com.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {

	private static WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
		
	}
	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
}
