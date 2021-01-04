package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest extends Pojo{
	private Xls_Read read;
	
	public void initializeEnvironment()
	{
		read =new Xls_Read("D:/Deepali/AmazonAutomation/src/test/resources/com/testData/testCaseData.xlsx");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		setDriver(new ChromeDriver());
		getDriver().get(read.getCellData("AmazonSheet",1 , 0));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		
	}

}
