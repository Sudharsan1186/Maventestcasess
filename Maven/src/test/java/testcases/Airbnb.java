/*1) Go to https://www.airbnb.co.in/
2) Type Baga in location and select Baga Beach, Baga
3) Under Select check-in date, choose check in date after 10 days from now 
   and checkout date as 5 days  after
4) Select 3 days in My dates are flexible
5) Select 2 Adults, one kid in Guest field and  click search
6) Select Hotel Room as type of place and Price as minimum 1000 , maximum as 10000
7) Click More filters add bed as 2, bedroom as one and click show stays
8) Click the first result and go to the new window
9) Capture the Price for one night
10) Check your chosen date is selected above reserve button
11) Calculate the one night price x 5 days which is displayed in the page is match
12)  Close the browser.
To select a Date in Java
LocalDate today = LocalDate.now();
int Date = today.getDayOfMonth();
int year = today.getYear();
int month = today.getMonthValue();

System.out.println(Date+5);*/



package testcases;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Airbnb {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		ChromeOptions options = new ChromeOptions();
		//1) Go to https://www.airbnb.co.in/
		
		String url = "https://www.airbnb.co.in/";
		driver.navigate().to(url);	
		
	    
		//2) Type Baga in location and select Baga Beach, Baga
		driver.findElementByXPath("//input[@id='bigsearch-query-detached-query']").sendKeys("Baga");
		driver.findElementByXPath("//div[text()='Baga Beach, Baga']").click();
		
		
		//3) Under Select check-in date, choose check in date after 10 days from now and checkout date as 5 days  after
	     WebElement calendar = driver.findElementByXPath("(//div[text() ='Add dates'])[1]");
	     calendar.click();
	    // WebElement fromdate = driver.findElementByXPath("(//table[@role='presentation'])[1]");
	     LocalDate today = LocalDate.now();
	     int Date = today.getDayOfMonth();
	     int year = today.getYear();
	     int month = today.getMonthValue();
	     System.out.print(Date+"/"+month+"/"+year);
	     
	}	

	}


