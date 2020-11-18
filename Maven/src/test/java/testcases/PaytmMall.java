/*1. Go to https://paytmmall.com/
2. Click on Shop by catogery
3. Mouse over on TVs & Appliances and click on Air Purifiers under Home Appliances
4. Set the price as minimum 5000 and max 15000
5. sort the product by popular
6. click on the first product and go to the new window
7. Click on Select EMI
8. Get the first 6 bank's EMI amount and Total Interest amount for 9 months and add it into Map
9. Pick the least EMI amount and verify the total interest amount(EMI amount * 9m -(original cost))
10. Select the least EMI amount and close EMI tab
11. Click on view more offers and select the highest amount and verify 
12. Click on Buy Now and close the browser*/



package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaytmMall {

	public static void main(String[] args) throws InterruptedException 
	{ 
		//1. Go to https://paytmmall.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("https://paytmmall.com/");
		
		Thread.sleep(5000);
		//2. Click on Shop by catogery		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() ='Shop By Category']"))).click();
		
		Thread.sleep(5000);
		//3. Mouse over on TVs & Appliances and click on Air Purifiers under Home Appliances
		WebElement element = driver.findElementByXPath("//a[text()='TVs & Appliances']");
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		
		driver.findElementByPartialLinkText("Air Purifiers").click();
		
		Thread.sleep(5000);
		//4. Set the price as minimum 5000 and max 15000		 
		WebElement min = driver.findElementByXPath("//input[@placeholder='Min']");
		min.click();
		min.clear();
		min.sendKeys("5000");
		
		Thread.sleep(5000);		
		WebElement max = driver.findElementByXPath("//input[@placeholder='Max']");
		max.click();
		max.clear();
		max.sendKeys("15000");
		
		//5. sort the product by popular
		driver.findElementByXPath("(//i[@class='iconArrowRight'])[2]").click();
		driver.findElementByXPath("(//div[text() ='Popular'])[2]").click();
		
		//6. click on the first product and go to the new window
		

	}

}
