/*1.Goto Url "https://www.gap.com/" and close if any pop-up exists
2.Click on Gap Factory
3.Mouse Over on New Arrivals and click Baby Girl
4.Click on "Baby Girl Shop by Size" on the left side under Shop By Size
5.Get the Total no.of items displayed at top near Category
6.Take the total item from the result
 navigate to second page and get the balance product count if exists
7.match the total product count with the result count
8.click on category and select "pants & jeans"
9.Select the first product
10.Select the size as "6-12 M"
11.Find the Discount Amount from the total price
12.Click on Add to Cart and CheckOut
13.Close the Browser*/



package monday.fiveoctober;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gap {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//1.Goto Url "https://www.gap.com/" and close if any pop-up exists
		driver.get("https://www.gap.com/");
		Thread.sleep(8000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(windowHandles);
		String newwindow = allWindows.get(0);
		driver.switchTo().window(newwindow);		
		driver.findElementByXPath("//button[@aria-label='close email sign up modal']").click();
		
		
		//2.Click on Gap Factory
		driver.findElementByLinkText("Gap Factory").click();
		
		//3.Mouse Over on New Arrivals and click Baby Girl
		WebElement newarrivals = driver.findElementByXPath("//button[text() ='New Arrivals']");
		Actions builder = new Actions(driver);
		builder.moveToElement(newarrivals).perform();		
		driver.findElementByLinkText("Baby Girl").click();
		
		//4.Click on "Baby Girl Shop by Size" on the left side under Shop By Size
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Baby Girl Shop by Size"))).click();
		
		//5.Get the Total no.of items displayed at top near Category
		String count = driver.findElementByXPath("//div[@class='category__item-count']").getText();
		System.out.println(count);
		
		
		//6.Take the total item from the result navigate to second page and get the balance product count if exists
		WebElement next = driver.findElementByXPath("//button[@aria-label='Next Page']");
		js.executeScript("arguments[0].scrollIntoView;",next);
		
		
		
		
		
	}

}
