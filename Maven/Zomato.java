/*1. Launch Chrome browser(Headless mode)
2. Go to "https://www.zomato.com/chennai"
3. Select Velachery and Type 'A2B - Adyar Anada Bhavan' in the restaurant/cuisine textbox
4. Choose the last listed option in auto suggested
5. Click order online and print if the restaurant is open or closed for delivery
6. Print the number of 'Must Try' items listed
7. Print the costliest sweet in that page
8. Click on photos and validate the number of photos listed matches the total number
   images displayed across the listed pages.*/


package monday.fiveoctober;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato {

	public static void main(String[] args) throws InterruptedException
	{
		//1. Launch Chrome browser(Headless mode)
		
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless");
		 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions builder = new Actions(driver);
		//2. Go to "https://www.zomato.com/chennai"
		try {
			driver.get("https://www.zomato.com/chennai");
		} catch (Exception e) {
			driver.get("https://www.zomato.com/chennai");
		}
		
		//3. Select Velachery and Type 'A2B - Adyar Anada Bhavan' in the restaurant/cuisine textbox
		driver.findElementByXPath("//*[@id='root']/div[2]/div[3]/div[2]/div[2]/div/div[1]/i[2]").click();
		driver.findElementByXPath("//p[text() ='Velachery, Chennai']").click();
		WebElement Hotel = driver.findElementByXPath("//input[@placeholder='Search for restaurant, cuisine or a dish']");
        Hotel.click();
        Hotel.sendKeys("Adyar Anada Bhavan");
		
		//Clicks on last element of a dropdown
		//driver.findElementByXPath("(//*[@id='root']/div[2]/div[3]/div[2]/div[2]/div/div[3]/div[2]/div/div)[last()]").click();
		
      //4. Choose the last listed option in auto suggested
        WebElement elem = driver.findElement(By.xpath("(//div//div[@class='sc-iNhVCk GSAgl'])[last()]"));
        js.executeScript("arguments[0].scrollIntoView;",elem);
        builder.moveToElement(elem).click(elem).build().perform();
        
      //5. Click order online and print if the restaurant is open or closed for delivery
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Order Online"))).click();
		System.out.println(driver.findElementByXPath("//*[@id='root']/div[2]/main/div/section[3]/section/section[1]/section[2]/section/span").getText());
		
	 //6. Print the number of 'Must Try' items listed
		List<WebElement> musttry = driver.findElementsByXPath("(//*[@id=\"root\"]/div/main/div/section[4]/section/section[2]/section[2]/div[2])/div");
		int size = musttry.size();	
		System.out.println(size);

	}
}
	


