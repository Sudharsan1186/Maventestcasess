
/*1. Launch the edge browser
2. Print the Edge browser version
3. Go to "https://www.redbus.in/"
4. Enter To as "Bangalore" and select Bangalore(All Locations)
5. Give shift + Tab and enter From as "Chennai" and select Chennai(All Locations)
6. Choose Date as first monday of next month
7. Click Search Buses and print total number of displayed buses
8. Select Bus Type as Sleeper 
9. Print the price and no of Seats available in first result
10. Mouse over on View Seats and click on Bus Photos
11. Take a screen shot of bus image if available or print the message "No Bus Image Found"*/


package monday.fiveoctober;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusEdgeBrowser {

	public static void main(String[] args) throws InterruptedException
	{
		//1. Launch the edge browser
        WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		Actions builder = new Actions(driver);
		
		//2. Print the Edge browser version
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName+" "+browserVersion);
		
		//3. Go to "https://www.redbus.in/"
		try {
			driver.get("https://www.redbus.in/");
		} catch (Exception e) {
			driver.get("https://www.redbus.in/");
		}
		
		//4. Enter To as "Bangalore" and select Bangalore(All Locations)
		WebElement destination = driver.findElement(By.id("dest"));
		
		//5. Give shift + Tab and enter From as "Chennai" and select Chennai(All Locations)
		destination.sendKeys("Bangalore",Keys.ENTER,Keys.SHIFT,Keys.TAB, "Chennai", Keys.ENTER);
		
		//6. Choose Date as first monday of next month
		driver.findElement(By.id("onward_cal")).click();
		
			
		/*
		 * String Month = "Jan 2021";
		 * 
		 * while(true) { String monthname =
		 * driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		 * 
		 * if (monthname.equals(Month)) break; else {
		 * driver.findElement(By.xpath("//td[@class='next']")).click(); } }
		 */
		
		String button = "//*[@id='rb-calendar_onward_cal']/table//tr[1]/td[3]/button";
		driver.findElement(By.xpath(button)).click();
		List<WebElement> firstmonday = driver.findElements(By.xpath("//th[contains(text(),'Mo')]/following::tr/td[1]"));
		List<String> val = new ArrayList<String>();
		
	
		  // Select the date values except space 
		for (WebElement lst : firstmonday) {
		  if (!lst.getText().isEmpty()) 
		  { 
			  val.add(lst.getText());
			  
          } 
		}
		 
		String first_monday = val.get(0);
		System.out.println("First Monday Date is : " + first_monday);

		// Select first monday from calender
		for (WebElement values : firstmonday) {
			if (values.getText().equals(first_monday)) {
				values.click();
			}
		}
		
		//7. Click Search Buses and print total number of displayed buses
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@class='fl button']")).click();
		
		//8. Select Bus Type as Sleeper 
		driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]")).click();
		
		
		//9. Print the price and no of Seats available in first result
		String Price = driver.findElement(By.xpath("(//div[@class='fare d-block']/span)[1]")).getText();
		String AvailableSeats = driver.findElement(By.xpath("(//div[@class='seat-left m-top-16'])[1]")).getText();
		System.out.println("The price of the Bus is :" +Price);
		System.out.println( "Number of availabel Seats is :" +AvailableSeats);
		
		//10. Mouse over on View Seats and click on Bus Photos
		WebElement ViewSeats = driver.findElement(By.xpath("(//div[@class = 'button view-seats fr'])[1]"));
		builder.moveToElement(ViewSeats).perform();
		
		driver.findElement(By.xpath("//span[text()='Bus Photos']")).click();
		String Image = driver.findElement(By.xpath("(//div[@class='t-center'])[1]")).getText();
		
		if(Image.contentEquals("No Bus Image Found"))
		{
			System.out.println("No Bus Image Found");
		}
		
		else {
			System.out.println("Bus Image Found");
		}

	}

}
