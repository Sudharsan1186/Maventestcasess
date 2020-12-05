package monday.fiveoctober;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,45);
		
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElementById("password").sendKeys("India$123");
		driver.findElementById("Login").click();
		//driver.switchTo().alert().dismiss();
		
		
		//2. Click on toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		// 3. Click view All 
		driver.findElementByXPath("//button[text() = 'View All']").click();
		
		//4. Click Service Console from App Launcher
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text() ='Service Console']"))).click();
		
		//5. Select Home from the DropDown
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-context-bar__icon-action']"))).click();
		driver.findElementByXPath("(//span[text() ='Home'])[2]").click();

	}

}
