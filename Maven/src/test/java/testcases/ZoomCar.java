/*Launch URL: https://www.zoomcar.com/chennai
2. Click on the Start your wonderful journey link
3. In the Launch URL: https://www.zoomcar.com/chennaiSearch page, Click on any pick up point under POPULAR PICK-UP
4. Click on the Next button
5. Specify the Start Date as tomorrow Date
6. Click on the Next Button
7. Confirm the Start Date and Click on the Done button
8. In the result page, capture the number of results displayed.
9. Find the highest priced car ride.
10. Click on the Book Now button for it.
11. Close the Browser.
*/

package testcases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCar 
{
	public static void main(String[] args) throws InterruptedException 
	{
	//1.Launch URL: https://www.zoomcar.com/chennai
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver,30);
	driver.get("https://www.zoomcar.com/chennai/");
	
	driver.findElementByXPath("(//div[@class='user-bar']//span)[2]").click();
	Set<String> allwindows = driver.getWindowHandles();
	List<String> listofallwindows = new ArrayList<String>(allwindows);
	String loginwindow = listofallwindows.get(0);
	driver.switchTo().window(loginwindow);	
	
	Thread.sleep(3000);
	WebElement number = driver.findElementByXPath("//input[@placeholder='Enter your E-mail or Mobile number']");
	number.click();
	number.sendKeys("9962066636",Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).sendKeys("password112",Keys.ENTER);
		
	driver.switchTo().defaultContent();
	
	
	Thread.sleep(3000);
	//2. Click on the Start your wonderful journey link
	driver.findElementByLinkText("Start your wonderful journey").click();
	
	//3. In the Launch URL: https://www.zoomcar.com/chennaiSearch page, Click on any pick up point under POPULAR PICK-UP
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='component-popular-locations']/div)[2]"))).click();
	
	//4. Click on the Next button
	WebElement Next = driver.findElementByXPath("//button[text() = 'Next']");
	Next.click();
	
	//5. Specify the Start Date as tomorrow Date
	LocalDate today = LocalDate.now();
	WebElement dateSelected = driver.findElementByXPath("(//div[@class='days']/div)[2]");
	dateSelected.click();
	
	//6. Click on the Next Button
	Next.click();
	
	//7. Confirm the Start Date and Click on the Done button
	driver.findElementByXPath("//button[text() = 'Done']").click();
	
	//8. In the result page, capture the number of results displayed.
	Thread.sleep(5000);
    List<WebElement> carlist = driver.findElementsByXPath("//div[@class='car-listing']//h3");	
    System.out.println(carlist.size());
    
	//9. Find the highest priced car ride.
    List<WebElement> price = driver.findElementsByXPath("//div[@class='car-listing']//div[@class='price']");
    TreeMap<Integer,String> map = new TreeMap<Integer,String>();
    for(int i=0;i<carlist.size();i++)
    {
    	String carname = carlist.get(i).getText();
    	String carprice = price.get(i).getText();
    	carprice = carprice.replaceAll("[^\\d]", "");
    	map.put(Integer.parseInt(carprice),carname);
    }
    System.out.println(map);
    System.out.println(map.descendingKeySet());
    System.out.println("HighestPrice: " + map.lastEntry());
    
    //10. Click on the Book Now button for it.
    for(int i=0;i<carlist.size();i++)
    {
    	System.out.println("Booking Key: " +map.lastEntry().getValue());
    	System.out.println("Text: " + carlist.get(i).getText());
    	if(map.lastEntry().getValue().equalsIgnoreCase(carlist.get(i).getText()))
    	{
    		driver.findElementByXPath("//button[@name='book-now']").click();
    		
    		   		
    	}
    }
    	
    }
    
    
	
    
    
  
}

