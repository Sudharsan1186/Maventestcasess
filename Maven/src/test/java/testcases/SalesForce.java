/*
1. Login to https://login.salesforce.com/?locale=in
2. Gve username as hari.radhakrishnan@testleaf.com and password as India$123
3. Click on menu button from the left corner
4. Click view All and click Service Console from App Launcher
5. Click on the arrow mark from the top menu and click Products
6. Click on New
7. Give Product Name
8.Select Active 
9. Click Save 
//(Print the success message "success Product "iron materials" was created.)
10. Verify the Product name and click New Contact
11. Select Salutation as Mr and give First and Last Name
12. Select Account Name and give Title
13. Click Save*/



package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException 
	{
	//1. Login to https://login.salesforce.com/?locale=in
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver = new ChromeDriver();
	 WebDriverWait wait = new WebDriverWait(driver,30);
	 driver.manage().window().maximize();
	 driver.get("https://login.salesforce.com/?ocale=in"); 	  
	 	 
	//2. Gve username as hari.radhakrishnan@testleaf.com and password as India$123
	 driver.findElementById("username").sendKeys("hari.radhakrishnan@testleaf.com");
	 driver.findElementById("password").sendKeys("India$123");
	 driver.findElementById("Login").click();	
	 
	 
	//3. Click on menu button from the right corner
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
	 
	//4. Click view All and click Service Console from App Launcher
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='View All']"))).click();
	 ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	 Set<String> windowHandles = driver.getWindowHandles();
	 List<String> newwindow = new ArrayList<String>(windowHandles);
	 String window = newwindow.get(0);
	 driver.switchTo().window(window);
	 Thread.sleep(5000);
	 driver.findElementByXPath("//p[text() ='Service Console']").click();
	 
	 
	//5. Click on the arrow mark from the top menu and click Products
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Show Navigation Menu']"))).click();
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Products'])[2]"))).click();
	 
	//6. Click on New
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']"))).click();
	 
	//7. Give Product Name
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class=' input'])[1]"))).sendKeys("Test");
	 
	//8.Select Active
	 driver.findElementByXPath("//input[@data-interactive-lib-uid='7']").click();
	 
	//9. Click Save 
	//(Print the success message "success Product "iron materials" was created.)
	 driver.findElementByXPath("(//span[text() = 'Save'])[2]").click();
	 
	 
	//10. Verify the Product name and click New Contact
	// driver.findElementByXPath("//div[@title='New Contact']").click();
	 
	 int count = 0;
     
     WebElement elem = driver.findElement(By.xpath("//div[@title='New Contact']"));
     System.out.println("Scrolling using JS..");
     ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
     System.out.println("In SCrolling method.");
     Thread.sleep(2000);
     boolean isClickable = false;
     while (!isClickable && count < 30) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,15)");
            try {
                  elem.click();
                  isClickable = true;
                  System.out.println("Element found and clicked after scrolling..");
                  break;
            } catch (Exception e) {
                  isClickable = false;
                  count++;
            }
     }

	 
	//11. Select Salutation as Mr and give First and Last Name
	Set<String> contactwindow = driver.getWindowHandles();
	List<String> contact = new ArrayList<String>(contactwindow);
	String contacts = contact.get(0);
	driver.switchTo().window(contacts);
	
	driver.findElementByXPath("//div[@data-proxy-id='aura-pos-lib-1']//div/a").click();
	
	}

	
}
