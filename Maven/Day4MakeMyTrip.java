package monday.fiveoctober;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4MakeMyTrip {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//1) Go to https://www.makemytrip.com/
		driver.get("https://www.makemytrip.com/");
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("webklipper-publisher-widget-container-notification-frame")));
		Thread.sleep(5000);
		driver.findElementByXPath("//a[@class='close']").click();
		driver.switchTo().defaultContent();
		ChromeOptions options = new ChromeOptions();
		 
		//2) Click Hotels
		try
		{
		WebElement Hotel = driver.findElementByLinkText("Hotels");
		wait.until(ExpectedConditions.visibilityOf(Hotel)).click();
		}
		catch(Exception e)
		{
		driver.findElementByXPath("//li[@data-cy='account']").click();
		driver.findElementByLinkText("Hotels").click();
		}
		
		
		//3) Enter city as Goa, and choose Goa, India
		driver.findElementById("city").click();
		WebElement inputcity = driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
		wait.until(ExpectedConditions.visibilityOf(inputcity)).sendKeys("Goa");
		Thread.sleep(3000);
		driver.findElementByXPath("//li[@id='react-autowhatever-1-section-0-item-0']").click();
		
		//4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5
		driver.findElementByXPath("//div[text()='20']").click();
		
		driver.findElementByXPath("//div[@aria-label='Mon Nov 02 2020']").click();
		
		//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
		driver.findElementById("guest").click();
		
		driver.findElementByXPath("//li[@data-cy='adults-3']").click();
		driver.findElementByXPath("//li[@data-cy='children-2']").click();
		
		WebElement firstChildAge = driver.findElementByXPath("//select[@data-cy='childAge-0']");
		Select se = new Select(firstChildAge);
		se.selectByIndex(2);
		
		WebElement secondChildAge = driver.findElementByXPath("//select[@data-cy='childAge-1']");
		Select se1 = new Select(secondChildAge);
		se1.selectByIndex(1);
		
		//6) Click Search button
		driver.findElementByXPath("//button[@data-cy='submitGuest']").click();
		driver.findElementByXPath("//button[@id='hsw_search_button']").click();
		
		//7) Select locality as Baga
		WebElement Locality = driver.findElementByXPath("//span[text() ='Baga']");
		wait.until(ExpectedConditions.visibilityOf(Locality)).click();
		
		//8) Select 5 start in Star Category under Select Filters
		WebElement starRating = driver.findElementByXPath("//label[text() ='5 Star']");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text() ='5 Star']")));
		
		//9) Click on the first resulting hotel and go to the new window
		WebElement Hotel = driver.findElementByXPath("(//p[@id='hlistpg_hotel_name'])[1]");
		wait.until(ExpectedConditions.visibilityOf(Hotel)).click();
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowhandles);
		String newWindow = window.get(1);
		driver.switchTo().window(newWindow);
		
		Thread.sleep(5000);
		//10) Print the Hotel Name 
		WebElement name = driver.findElementById("detpg_hotel_name");
		String hotelname = name.getText();
		System.out.println("The Hotel Name is : " +hotelname);
		
		//11) Click on BOOK THIS NOW
		driver.findElementByXPath("//span[text() ='Book this combo']").click();
		
		//12) Print the Total Payable amount
		WebElement popup = driver.findElementByXPath("//label[@for='leaveNow']");
		wait.until(ExpectedConditions.visibilityOf(popup)).click();
		driver.findElementByXPath("//span[@class='close']").click();
		WebElement amount = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']");
		String cost = amount.getText();
		System.out.println("Total COst is : " +cost);
		
		driver.quit();
	}
}
