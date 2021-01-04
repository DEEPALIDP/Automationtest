package com.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookFlight {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(driver, 50);
	public BookFlight(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		
	}
	//By nonstop=By.xpath("//p[text()='Non-stop']/../../../div/span");
	//By book=By.xpath("//button[text()='Book']");
	public void click_NonStop() {

		WebElement nonstopelement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Non-stop']/../../../div/span")));
		

		js.executeScript("arguments[0].click();", nonstopelement);		
	}

	public void select_DepartureFlight(String flight,String fIndex) {

		WebElement depFlight = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-test-attrib='onward-view']//img[@alt='"+flight+"'])["+fIndex+"]")));

		js.executeScript("arguments[0].click();", depFlight);		
	}
	public void select_returnFlight(String flight,String fIndex) {

		WebElement depFlight = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-test-attrib='return-view']//img[@alt='"+flight+"'])["+fIndex+"]")));

		js.executeScript("arguments[0].click();", depFlight);		
	}
	
	public void click_BookButton()
	{
		WebElement bookbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Book']")));

		js.executeScript("arguments[0].click();", bookbutton);	
	}

	
	
	

}

