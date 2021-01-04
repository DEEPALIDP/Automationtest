package com.script;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pages.HomePage;

public class AmazonTest extends BaseTest {
	private HomePage objHome;
	public void InitializeViewAndPages()
	{
		objHome=new HomePage(this);
	}
	
	@BeforeTest
	public void init()
	{
		this.initializeEnvironment();
		this.InitializeViewAndPages();
	}
	@Test
	public void amazonTest()
	{
		
		objHome.verifyAmazonHomePagetitle();
		objHome.clickOnAmazonPageAmazonPayLink();
		//objHome.verifyAmazonPayPagetitle();
		objHome.navigateOnAmazonHomeOPage();
		objHome.printAlllinkOnhomePage();
	}

}
