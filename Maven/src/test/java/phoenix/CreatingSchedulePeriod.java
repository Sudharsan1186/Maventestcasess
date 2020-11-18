package phoenix;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingSchedulePeriod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		// Login
		driver.get("http://phoenixweb-crqa.turner.com/");
		driver.findElementById("MainContent_UserName").sendKeys("Sudharson.Subbiah@turner.com");
		driver.findElementById("MainContent_Password").sendKeys("Chennai1234@");
		driver.findElementById("MainContent_RememberMe").click();
		driver.findElement(By.id("MainContent_LoginButton")).click();

		Thread.sleep(5000);
		// Select Network
		driver.findElementByXPath("//div[@class ='ui-select-match']//i").click();
		driver.findElementByXPath("//img[@title = 'ADSM']").click();

		Thread.sleep(10000);
		// Select Schedule Period
		driver.findElementByPartialLinkText("Schedule").click();

		Thread.sleep(10000);
		
		
		   driver.findElementByXPath("(//button[contains(text(),'Actions')])[1]").click();
		  /*List<WebElement> Actions =driver.findElementsByXPath("(//button[contains(text(), 'Actions')])");
		  
		
			
			  WebElement Schedule =	driver.findElement(By.xpath("(//div[@class ='log-day no-schedule-period'])"));
			  
			  String color = Schedule.getCssValue("background-color");
			  
			  System.out.println(color);
			  
				
				 * if (Schedule.isDisplayed()) {
				 * driver.findElementByXPath("//button[contains(text(), 'Actions')]").click();
				 * 
				 * }
			 
		    
		       	 		
			  WebElement schedule =  driver.findElementByXPath("//button[contains(text(), 'Actions')]"); 
			  for (int i =1;i<=Actions.size();i++) 
			  { 
				  if (color.contains("rgba(255, 255, 255, 1)")) {
			  driver.findElementByXPath("(//button[contains(text(), 'Actions')])["+i+"]").click(); 
			 break;		  
			  }*/
				  
				 Thread.sleep(10000);
			    //Create Schedule period
				driver.findElementByLinkText("Create Schedule Period").click();
				Thread.sleep(5000);
				driver.findElementById("schedulePeriodDescription").sendKeys("Week");
				driver.findElementByXPath("//button[@ng-click='save()']").click();
				
				Thread.sleep(3000);
				
				
				//Import Logs
				driver.findElementByXPath("(//button[contains(text(),'Actions')])[1]").click();
				Thread.sleep(3000);
				driver.findElementByLinkText("Add Promo Groups").click();
				
				
				Thread.sleep(5000);
				//Add Promogroups
				driver.findElementByXPath("//div[@ng-click='togglePromoSearch()']").click();
				
			
				//SelectpSrevious week data
				WebElement week = driver.findElementByXPath("//select[@name='periods']");
				Select obj = new Select(week);
				obj.selectByIndex(1);
				
				Thread.sleep(3000);
				driver.findElementByXPath("//button[@ng-click='CopyPeriodPromoGroups()']").click();
				
				Thread.sleep(3000);
				driver.findElementByXPath("(//button[@class='btn btn-sm btn-log-notimported'])[1]").click();
				Thread.sleep(3000);
				driver.findElementByLinkText("Import").click();
									
				Thread.sleep(30000);				
				//view Logs
				
				driver.findElementByXPath("//button[@class='btn btn-sm btn-log-imported']").click();
				driver.findElementByLinkText("View Log").click();
				
				Thread.sleep(10000);
				
				
				
			  }
			 
		
		
}	
		
		
		
		

