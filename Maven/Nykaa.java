/*1.Launch URL "https://www.nykaa.com/"
2.Enter text as perfumes in search bar and hit Enter
3.Get the names of all the perfumes displayed.
4.Get the price of all the perfumes displayed.
5.Click on highest price perfume.
6.click on Add to bag.
7.verify Message product Added to the bag.
8.click on bag icon.
9.Get the Grand Total value.
10.click on proceed. 
11.Click on continue as Guest. 
12.Fill all the Fields in address.
13.click on paynow. 
14.Get the error message displayed in red colour.
15.Close the Browser.*/ 


package monday.fiveoctober;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) 
	{
		//1.Launch URL "https://www.nykaa.com/"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("https://www.nykaa.com/");
		
		//2.Enter text as perfumes in search bar and hit Enter
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("SearchInputBox")));
		search.click();
		search.sendKeys("perfumes",Keys.ENTER);
		
		//3.Get the names of all the perfumes displayed.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='view-more-btn common-btn']"))).click();
		
		

	}

}
