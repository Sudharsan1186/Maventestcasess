package monday.fiveoctober;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5BigBAsket {
    
	public static void main(String[] args) throws InterruptedException 
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	//1) Go to https://www.bigbasket.com/
	driver.get("https://www.bigbasket.com/");
	
	//2) mouse over on  Shop by Category 
	Thread.sleep(10000);
	WebElement Mouseover = driver.findElementByXPath("//a[@ng-mouseover='vm.readyToShow = true']");
	Actions builder = new Actions(driver);
	builder.moveToElement(Mouseover).perform();
	
	//3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
    WebElement dropdown = driver.findElementByLinkText("Foodgrains, Oil & Masala");
    builder.moveToElement(dropdown).perform();
    
    WebElement option = driver.findElementByLinkText("Rice & Rice Products");
    builder.moveToElement(option).perform();
    
    //4) Select Boiled & Steam Rice
    driver.findElementByLinkText("Boiled & Steam Rice").click();
    
    //5) Select the Brand as bb Royal
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text() ='bb Royal'])[1]"))).click();
    
    Thread.sleep(8000);
    //6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown    
    driver.findElementByXPath("(//button[@class='btn btn-default dropdown-toggle form-control'])[3]").click();    
    driver.findElementByXPath("(//a[@ng-click='vm.onProductChange(allProducts)'])[9]").click();
    
    //7) print the price of Rice
    WebElement cost = driver.findElementByXPath("(//span[@class='discnt-price'])[3]");
    String price = cost.getText();
    System.out.println("The Total cost is : " +price);
   
    Thread.sleep(2000);
    //8) Click Add button
    driver.findElementByXPath("(//button[@qa='add'])[3]").click();
		/*
		 * try { WebElement popup = driver.
		 * findElementByXPath("//div[text() = 'Successfully added Ponni Boiled Rice - Super Premium 5 kg to the basket']"
		 * ); boolean displayed = popup.isDisplayed(); if(displayed) {
		 * System.out.println(displayed); } else { System.out.println("Wrong message");
		 * } } catch(Exception e) { WebElement msg =
		 * driver.findElementByXPath("//div[@class ='toast-title']"); String text =
		 * msg.getText(); String expectedText =
		 * "Successfully added Ponni Boiled Rice - Super Premium 5 kg to the basket";
		 * Assert.assertEquals(text,expectedText);
		 * 
		 * }
		 */
    
    //10) Type Dal in Search field and enter
		WebElement search = driver.findElementByXPath("//input[@qa='searchBar']");
		search.sendKeys("Dal");
		search.sendKeys(Keys.ENTER);
		
	//12) Go to Toor/Arhar Dal and select 2kg & set Qty 2 
		Thread.sleep(5000);
		driver.findElementByXPath("(//i[@class='fa fa-caret-down'])[2]").click();
		driver.findElementByXPath("(//a[@ng-click='vm.onProductChange(allProducts)'])[5]").click();
		WebElement quantity = driver.findElementByXPath("(//input[@ng-model='vm.startQuantity'])[2]");
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys("2");
		
	//13) Print the price of Dal
		WebElement dalprice = driver.findElementByXPath("(//span[@class='discnt-price'])[2]");
		String pricedal = dalprice.getText();
		System.out.println(pricedal);
		
    //14) Click Add button
		driver.findElementByXPath("(//button[@qa='add'])[2]").click();
	
		
	//15) Mouse hover on My Basket 
		Thread.sleep(8000);
		driver.findElementByXPath("//a[@qa='myBasket']").click();;
		
	//16) Validate the Sub Total displayed for the selected items
		WebElement Total = driver.findElementByXPath("(//span[text()='Rs '])[2]");
		String TotalCost = Total.getText();
	    System.out.println(TotalCost);
	    
	}

}
