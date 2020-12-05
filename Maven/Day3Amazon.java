package monday.fiveoctober;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3Amazon {

	public static void main(String[] args) throws InterruptedException 
	{
		//1. Launch URL: https://www.amazon.in/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudharson-s\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://www.amazon.in");
		
		//2. Type "oneplus 7 pro mobiles" in Search Box and Enter
		WebElement Search = driver.findElementById("twotabsearchtextbox");
		Search.sendKeys("oneplus 7 pro mobiles");
		Search.sendKeys(Keys.ENTER);
		
		//3. Print the price of the first resulting mobile
		Thread.sleep(5000);
		WebElement firstcontent = driver.findElementByXPath("(//span[@class = 'a-price-whole'])[1]");
		String price = firstcontent.getText();
		System.out.println(price);
		
		//4. Click on the Mobile (First resulting) image
		driver.findElementByXPath("//div[@class='a-section aok-relative s-image-fixed-height']/img").click();
		
		//5. Switch to the new window
	    Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(windowHandles);
		String newwindow = allWindows.get(1);
		driver.switchTo().window(newwindow);
		
		//6. Print the number of customer ratings
		WebElement rating = driver.findElementById("acrCustomerReviewText");
		String numofrating = rating.getText();
		System.out.println(numofrating);
		
		//7. Click 'Add to Cart'
		driver.findElementByXPath("//input[@title='Add to Shopping Cart']").click();
		
		Thread.sleep(5000);
		//8. Confirm "Added to Cart" text message appeared
		try
		{
		WebElement Cart = driver.findElementByXPath("//div[@id ='huc-v2-order-row-confirm-text']/h1");
		String Cartmessage= Cart.getText();
		if(Cartmessage.contains("Added to Cart"))
		{
			System.out.println("Item is added to Cart");
		}
		
		else {
			System.out.println("Item is not added");
		}
	    }
		catch(Exception e)
		{
			WebElement newcart = driver.findElementByXPath("//div[@class='a-box-inner a-alert-container']/h4");
			String newcartmessage = newcart.getText();
			if(newcartmessage.contains("Added to Cart"))
			{
				System.out.println("Item is added to Cart");
			}
			
			else {
				System.out.println("Item is not added");
			}
		}
		//9. Click on Proceed to checkout
		
		try
		{
			driver.findElementByPartialLinkText("Proceed to Buy").click();
		}
		
		catch(Exception e)
		{
			driver.findElementByXPath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']").click();
		}
		
		//10. Confirm the title is "Amazon Sign In"
		wait.until((ExpectedConditions.titleContains("Amazon Sign In")));
		String title = driver.getTitle();
		if(title.contains("Amazon Sign In"))
		{
			System.out.println("The Correct Page is Displayed");
		}
		else
		{
			System.out.println("You are in the Wrong page");
		}
	    
		//11. Click Continue (without entering mobile number / email)
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
		
		
		//12. Verify the error message: Enter your email or mobile phone number
		WebElement error = driver.findElementByXPath("(//div[@class='a-alert-content'])[2]");
		String errmsg = error.getText();
		
		if(errmsg.contains("Enter your email or mobile phone number"))
		{
			System.out.println("Correct Error Message");
		}
		else
		{
			System.out.println("Wrong Error");
		}
		
		//13. Close both browsers
		driver.quit();
		}
	
		

	}



