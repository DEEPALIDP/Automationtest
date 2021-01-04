package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelutility.Xls_read;
//import com.excelutility.Xls_read;
import com.pages.BookFlight;
import com.pages.Itinery;
import com.pages.SearchFlightPage;

public class Test_Case {
	WebDriver driver;
	SearchFlightPage objsearchFlight;
	BookFlight objbookFlight;
	Itinery objItinery;
	Xls_read read;

	@BeforeTest
	// browser setup
	public void setup_Browser() {
		read = new Xls_read(System.getProperty("user.dir") + "\\src\\com\\testdata\\CleartripTestData.xlsx");
		//String url = read.getDataObject("SearchFlight");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// set runtime environmental path
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
	}

	/*@DataProvider(name = "loginDP")
	public Object[][] loginDP() {	
		
		return read.getDataObject("SearchFlight");
	}*/
/*
	@DataProvider(name = "HomeDP")
	public Object[][] HomeDP() {		
		return new Object[][] { 
			{ "Guru99", "India" ,},
			{ "Krishna", "UK" }, 
			{ "Bhupesh", "USA" } };

	}*/
	
	@Test(dataProvider="loginDP")
	public void CheckPageAppearCorrect(String from,String to, String departon,String returnon,String adult) throws InterruptedException {
		/*String from = read.getCellData("SearchFlight", 1, 1);
		String to = read.getCellData("SearchFlight", 1, 2);
		String departon = read.getCellData("SearchFlight", 1, 3);
		String returnon = read.getCellData("SearchFlight", 1, 4);
		String adult = read.getCellData("SearchFlight", 1, 5); */

		// create object of search flight page
		objsearchFlight = new SearchFlightPage(driver);
		objsearchFlight.click_onFlights();
		objsearchFlight.click_onRoundtrip();
		objsearchFlight.search(from,to,departon,returnon);

		
		 /* objsearchFlight.setFrom(read.getCellData("SearchFlight", 1, 1) );
		  objsearchFlight.setTo("New Delhi, IN - Indira Gandhi Airport (DEL)");
		  objsearchFlight.search(
		  "Mumbai, IN - Chatrapati Shivaji Airport (BOM)",
		  "New Delhi, IN - Indira Gandhi Airport (DEL)");
		 objsearchFlight.setDepartDate("Mon, 28 Sep, 2020");
		  objsearchFlight.setReturnDate("Tue, 29 Sep, 2020");*/
		
		objsearchFlight.selectAdult(adult);
		objsearchFlight.click_OnSearchFlight();
		// System.out.println(11);
	}

	@Test
	public void checkBookFlight() {
		// create object of BookFlight page
		objbookFlight = new BookFlight(driver);
		objbookFlight.click_NonStop();
		objbookFlight.select_DepartureFlight(read.getCellData("BookFlight", 1, 0),read.getCellData("BookFlight", 1, 2));
				
		objbookFlight.select_returnFlight(read.getCellData("BookFlight", 1, 1),read.getCellData("BookFlight", 1, 2));
		
		objbookFlight.click_BookButton();
		// System.out.println(22);
	}
	/*    XSSFCell cell = worksheet.getRow(rowIndex).getCell(0);
String contents = cell.getStringCellValue();

String[] items = contents.split(",");

for (String item : items) {
    System.out.println("Found csv item: " + item);
} */

	@Test
	public void checkItinery() throws Exception { // create object of Itinery
													// page
		objItinery = new Itinery(driver);

		objItinery.windowHandling();

		objItinery.click_ContinueShopping();

		objItinery.setEmailAddress(read.getCellData("TravllerInfo",1 , 0));

		objItinery.click_onContinue();

		objItinery.setTitle1(read.getCellData("TravllerInfo", 1, 1));

		objItinery.setfname1(read.getCellData("TravllerInfo",1 , 2));

		objItinery.setLname(read.getCellData("TravllerInfo",1 , 3));

		objItinery.setTitle2(read.getCellData("TravllerInfo",1 , 4));

		objItinery.setfname2(read.getCellData("TravllerInfo",1 , 5));

		objItinery.setLname1(read.getCellData("TravllerInfo",1 , 6));

		objItinery.setmobileno(read.getCellData("TravllerInfo",1 , 7));
		// System.out.println("hii");

		objItinery.click_onContinueButton1();
		objItinery.click_onNetbanking();
		objItinery.click_onKotak();
		objItinery.click_onMakePayment();

		WebElement imagefile = driver.findElement(By.xpath("//img[@alt='Kotak']"));
		Boolean logoPresent1 = imagefile.isDisplayed();
		Assert.assertTrue(logoPresent1, "LogoPrsent");
		if (logoPresent1 == true) {
			System.out.println("Logo is Present");
		} else {
			
			System.out.println("Logo is not present");
		}

	}

}
