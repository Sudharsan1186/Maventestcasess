package monday.fiveoctober;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustDial {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		//1) https://www.justdial.com/
		try {
			driver.get("https://www.justdial.com/");
		} catch (Exception e) {
			driver.getKeyboard().sendKeys(Keys.F5);
		}
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		//2) Set the Location as Chennai
		wait.until(ExpectedConditions.elementToBeClickable(By.id("city"))).clear();
		driver.findElementById("city").sendKeys("Chennai");
		
		
		//3) Click Auto Care in the left menu
		driver.findElementByXPath("//span[text() ='Auto care']").click();
		
		//4) Click Car Repair
		driver.findElementByXPath("//span[@title='Car Repair']").click();
		
		//5) Click Car Brand as Hyundai
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Hyundai'])[2]"))).click();
		//driver.findElementByXPath("(//span[@title='Hyundai'])[2]").click();
		
		//6) Click Make as Hyundai Xcent
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Hyundai Xcent'])[2]"))).click();
		
		
		//7) Click on Location and Enter Porur
		driver.findElementByXPath("//li[@id='location']//a").click();
		WebElement location = driver.findElementByXPath("//input[@id='sortbydist']");
		location.clear();
		location.sendKeys("porur");
		
		

	}

}
