/*1. Launch URL: https://www.amazon.in/
2. Type "oneplus mobiles phones" in Search Box and Enter
3. Print the price of the first resulting mobile
4. Click on the Mobile (Second resulting) image
5. Switch to the new window
6. Print the number of customer ratings
7. Click 'Add to Cart'
8. Search For samsung tv 55 inch
9. Click on the First Resulting Tv
10. Switch to New Window
11. Print The Amount and Customer Rating
12. Click on Add To Cart
13. Confirm "Added to Cart" text message appeared
14. Click on Cart and Print SubTotal
15. Click on Proceed To buy
16. Confirm the title is "Amazon Sign In"
17. Click Continue (without entering mobile number / email)
18. Verify the error message: Enter your email or mobile phone number
19. Close both browsers*/


package monday.fiveoctober;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonOnePlus {

	public static void main(String[] args) throws InterruptedException 
	{
		//1. Launch URL: https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("https://www.amazon.in/");
		
		//2. Type "oneplus mobiles phones" in Search Box and Enter
		WebElement search = driver.findElementById("twotabsearchtextbox");
		search.sendKeys("oneplus mobiles phones");
		search.sendKeys(Keys.ENTER);
		
		//3. Print the price of the first resulting mobile
		String price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-price-whole'])[1]"))).getText();
		System.out.println("Price of First Resulting Mobile is : " + price);
		
		//4. Click on the Mobile (Second resulting) image
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height']//img)[2]"))).click();
		
		
		
	     //5. Switch to the new window 
		 Set<String> newwindows = driver.getWindowHandles();
		 List<String> allWindows = new ArrayList<String>(newwindows); 
		 String firstwindow = allWindows.get(1);
		 driver.switchTo().window(firstwindow);
		  
		  //6. Print the number of customer ratings
		  WebElement rating = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id = 'acrCustomerReviewLink'])[1]")));
		  String numberofreview = rating.getText().substring(0, 6);
		  System.out.println("Total Number of CUstomer Ratings :" +numberofreview);
		 
		  //7. Click 'Add to Cart'
		  driver.findElementById("add-to-cart-button").click();
		  try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='attach-close_sideSheet-link']"))).click();
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  Thread.sleep(5000);
		  //8. Search For samsung tv 55 inch
		  WebElement newsearch = driver.findElementById("twotabsearchtextbox");
		  newsearch.clear();
		  newsearch.sendKeys("samsung tv 55 inch",Keys.ENTER);
		
		  
		//9. Click on the First Resulting Tv
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height']/img)[1]"))).click();
		 
		//10. Switch to New Window
		  Set<String> newwindows1 = driver.getWindowHandles();
			 List<String> allWindows1 = new ArrayList<String>(newwindows); 
			 String firstwindow1 = allWindows.get(1);
			 driver.switchTo().window(firstwindow1);
		  
		//11. Print The Amount and Customer Rating
		  String tvprice = wait.until(ExpectedConditions.elementToBeClickable(By.id("priceblock_dealprice"))).getText();
		  System.out.println("The TV price is : " +tvprice);
		  String text = driver.findElementByXPath("(//span[@id='acrCustomerReviewText'])[1]").getText().substring(0, 2);
		  
		
		
		

	}

}
