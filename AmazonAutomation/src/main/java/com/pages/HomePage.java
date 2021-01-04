package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.generic.Pojo;
import com.generic.Xls_Read;

public class HomePage {

	private Pojo objPojo;
	private String str;
	private Xls_Read read;
	public HomePage(Pojo objPojo) {
		this.objPojo=objPojo;
		read=new Xls_Read("D:/Deepali/AmazonAutomation/src/test/resources/com/testData/testCaseData.xlsx");		

		
	}

	//locators
	//links
	By lnkmobiles = By.linkText("Mobiles");
	By link=By.xpath("//div[@id='nav-xshop-container']");
	By lnkGiftCards=By.linkText("Gift Cards");
	
	
	public void verifyAmazonHomePagetitle()
	{
		String actual=objPojo.getDriver().getTitle();
		System.out.println(actual);
		String expected =  read.getCellData("AmazonSheet", 1, 1);
		Assert.assertEquals(actual, expected);
	}
	
	public void clickOnAmazonPageAmazonPayLink()
	{
		objPojo.getDriver().findElement(lnkmobiles).click();
	}
	public void verifyAmazonPayPagetitle()
	{
		String actual1=objPojo.getDriver().getTitle();
		System.out.println(actual1);
		String expected1= read.getCellData("AmazonSheet", 1, 2);
		Assert.assertEquals(actual1, expected1);
	}
	public void navigateOnAmazonHomeOPage()
	{
		objPojo.getDriver().navigate().back();
		String actual2=objPojo.getDriver().getTitle();
		System.out.println(actual2);
		String expected2= read.getCellData("AmazonSheet", 1, 1);
		Assert.assertEquals(actual2, expected2);
		
	}
	public void clickOnHomePageLinks()
	{
		objPojo.getDriver().findElement(link).click();
	}
	public void clickOnLinkHomePage(String site){
        objPojo.getDriver().findElement(By.xpath("//a[contains(text(),'"+site+"')]")).click();
        System.out.println("Click on "+site);
    }
	public void printAlllinkOnhomePage()
	{
		WebElement link = objPojo.getDriver().findElement(By.xpath("//div[@id='nav-xshop']"));
        String str = link.getText();
        System.out.println(str);
        
        if (str.contains("Gift Cards")) {
            System.out.println(str);
            this.clickOnLinkHomePage("Gift Cards");
            objPojo.getDriver().navigate().back();
        }
        
        if (str.contains("Best Sellers")) {
            this.clickOnLinkHomePage("Best Sellers");
            objPojo.getDriver().navigate().back();
        }
        if (str.contains("Mobiles")) {
        	 this.clickOnLinkHomePage("Mobiles");
        	 objPojo.getDriver().navigate().back();
        }
    
        if (str.contains("Prime")) {
        	this.clickOnLinkHomePage("Prime");
        	objPojo.getDriver().navigate().back();
        }
        if (str.contains("Customer Service")) {
        	this.clickOnLinkHomePage("Customer Service");
            objPojo.getDriver().navigate().back();
        }
        if (str.contains("New Releases")) {
        	this.clickOnLinkHomePage("New Releases");
            objPojo.getDriver().navigate().back();
        }
        if (str.contains("Fashion")) {
        	this.clickOnLinkHomePage("Fashion");
            objPojo.getDriver().navigate().back();
        }
       

 

    }

 
	
}
