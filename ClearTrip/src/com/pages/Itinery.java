package com.pages;

import java.util.Iterator;
//import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Itinery {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	Actions as;
		// TODO Auto-generated constructor stub
	public Itinery(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	By checkbox=By.xpath("//*[@id='itineraryBtn']");
	By continue_shopping=By.xpath("//input[@class='booking'][@id='itineraryBtn']");
	By email_address=By.xpath("//div[@id='Login']//input[@id='username']");
	By continue_button=By.id("LoginContinueBtn_1");

	By title1=By.xpath("//select[@name='AdultTitle1']");
	By fname=By.xpath("//input[@name='AdultFname1']");
	By lastname =By.xpath("//input[@name='AdultLname1'][@id='AdultLname1']");
	By title2=By.xpath("//select[@name='AdultTitle2']");
	By fname2 =By.xpath("//input[@name='AdultFname2']");
	By lastname2=By.xpath("//input[@name='AdultLname2']");
	By Mobile_no=By.xpath("//input[@type='tel'][@name='contact1']");
	By continue_button1=By.id("travellerBtn");
	By netbanking=By.linkText("Net Banking");
	By kotak=By.xpath("//span[@class='bankLogo truncate kotak_bank']");
	By makePayment=By.xpath("//input[@class='booking'][@value='Make payment']");
	public void windowHandling()
	{
		String mainweb = driver.getWindowHandle();
		Set <String> set = driver.getWindowHandles();
	//	System.out.println(set);
		Iterator <String> itr = set.iterator();
		while(itr.hasNext())
		{
		
			String child = itr.next();
			if(!mainweb.equals(child))
			{
				driver.switchTo().window(child);
				//System.out.println(driver.switchTo().window(child).getTitle());
		// driver.close();
		}
		}
		
		
			
 }
		
	public void click_ContinueShopping()
		{
			WebElement continue_shopping1 = wait
			.until(ExpectedConditions.elementToBeClickable(continue_shopping));
			js.executeScript("arguments[0].scrollIntoView();", continue_shopping1);
			js.executeScript("arguments[0].click();", continue_shopping1);	
			
		}
	public void setEmailAddress(String email)
	{
		WebElement webemail = wait
				.until(ExpectedConditions.elementToBeClickable(email_address));
		webemail.sendKeys(email);
		
		
	}
	public void click_onContinue(){
	
		driver.findElement(continue_button).click();
		
		
	}
	public void setTitle1(String t){
		WebElement select = driver.findElement(title1);

		js.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, t);
	
	}
	//set fname to text
	public void setfname1(String name)
	{
		driver.findElement(fname).sendKeys(name);
	}
	//set lastname to text
	public void setLname(String lname)
	{
		driver.findElement(lastname).sendKeys(lname);
	}
	//select title2
	public void setTitle2(String title)
	{
		 Select select2=new Select(driver.findElement(title2));
		 select2.selectByVisibleText(title);
	}
	
	//set fname1 to text
	public void setfname2(String name1)
	{
		driver.findElement(fname2).sendKeys(name1);
	}
	//set lastname2 to text
	public void setLname1(String lname1)
	{
		driver.findElement(lastname2).sendKeys(lname1);
	}
	public void setmobileno(String mbno)
	{
		driver.findElement(Mobile_no).sendKeys(mbno);
	}
	public void click_onContinueButton1()
	{
	
		driver.findElement(continue_button1).click();
		
	}
	public void click_onNetbanking(){
		driver.findElement(netbanking).click();
	}
	public void click_onKotak(){
		driver.findElement(kotak).click();
	}
	public void click_onMakePayment(){
		driver.findElement(makePayment).click();
	}
		
			
		
		
			
	}
	
	
	
