package monday.fiveoctober;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6HP {

	public static void main(String[] args) throws InterruptedException 
	{
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,45);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1) Go to https://store.hp.com/in-en/
		driver.get("https://store.hp.com/in-en/");
		
		//2) Mouse over on Laptops menu and click on Pavilion	
		
		WebElement cookiesclose = driver.findElementByXPath("//button[@class='optanon-alert-box-close banner-close-button']");
		wait.until(ExpectedConditions.visibilityOf(cookiesclose)).click();	  	 
		
		Thread.sleep(5000);
		WebElement laptop = driver.findElementByLinkText("Laptops");
		Actions builder = new Actions(driver);
		builder.moveToElement(laptop).perform();
		driver.findElementByLinkText("Pavilion").click();
		
		
		Thread.sleep(3000);
		//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
		driver.findElementByXPath("(//div[@data-code='hp_facet_processortype']//a/input)[1]").click();
		
		//4) Hard Drive Capacity -->More than 1TB 
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@data-title='Hard Drive Capacity']//a)[2]").click();
		Thread.sleep(3000);
		//5) Select Memory Standard as 8GB
		driver.findElementByXPath("(//div[@data-title='Memory standard']//a)[1]").click();		
		
		//6) Print the First resulting Product Name and Price
		WebElement getcost = driver.findElementByXPath("//span[@class='price-container price-final_price tax weee']//span/span");
		String cost = getcost.getText();
		System.out.println("The price of the First Element is :" +cost);
		
		Thread.sleep(4000);
		//7) Click on Add to Cart
		driver.findElementByXPath("//button[@class='action tocart primary']/span").click();
		
		//8) Click on Shopping Cart icon --> Click on View and Edit Cart
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Shopping Cart']"))).click();
		driver.findElementByXPath("//a[@class='action primary viewcart']").click();
		
		//9) Check the Shipping Option --> Check availability at Pincode"
		driver.findElementByName("pincode").sendKeys("600042");
		driver.findElementByXPath("//button[@class='primary standard_delivery-button']").click();
		
		//10) Verify the order Total against the product price
		WebElement itemcost = driver.findElementByXPath("(//td[@class='amount'])[1]");
		WebElement totalcost = driver.findElementByXPath("(//td[@class='amount'])[3]");
		
		//11) Proceed to Checkout if Order Total and Product Price matches
		
		if(itemcost == totalcost)
		{
			
			driver.findElementByXPath("(//button[@title='Proceed to Checkout'])[1]").click();					
			
		}
		
		else
		{
			System.out.println("Price did not match");
		}
		
		
		//12) Click on Proceed to Checkout and Click on Place Order
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Place Order'])[4]"))).click();
		
		
		WebElement error = driver.findElementByXPath("//div[@id='customer-email-error']");
		String emsg = error.getText();
		System.out.println(emsg);

	}

}
