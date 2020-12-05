/*1. Launch Firefox browser
2. Go to "https://dev96572.service-now.com/"
3. Login with user name @ password(admin, Tuna@123)
4. Wait until loading disappears
5. Type Oauth on the filter navigator
6. Click on Application Registries
7. Click New on Application Registries
8. Click Create an OAuth API endpoint for external clients
9. Fill Name with your name + current date(name_01122020)
10. Click Submit
11. Confirm OAuth Client is created*/



package monday.fiveoctober;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    driver.get("https://dev96572.service-now.com/");
	    
	    driver.switchTo().frame(0);
	    driver.findElementByCssSelector("input#user_name").sendKeys("admin");
	    driver.findElementById("user_password").sendKeys("Tuna@123");
	    driver.findElementById("sysverb_login").click();
	    driver.switchTo().defaultContent();
	    
	    
	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-indicator icon-loading icon-lg']")));
	    Thread.sleep(7000);
	    WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter")));
	    filter.click();
	    filter.sendKeys("Oauth");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() ='Application Registry']"))).click();
	    Thread.sleep(9000);
	    driver.switchTo().frame(0);
	    driver.findElementById("sysverb_new").click();
	    
	    //8. Click Create an OAuth API endpoint for external clients
	    driver.findElementByPartialLinkText("Create an OAuth API").click();
	    
	    //9. Fill Name with your name + current date(name_01122020)
	    WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("oauth_entity.name")));
	    name.click();
	    name.sendKeys("sudharshan12/03/20");
	    
	    //10. Click Submit
	    driver.findElementById("sysverb_insert_bottom").click();
	    
	    List<WebElement> cname = driver.findElementsByXPath("(//tbody[@class='list2_body']/tr)/td[3]//a");
	    System.out.println(cname);
	}

}
