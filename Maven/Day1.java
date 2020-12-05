package monday.fiveoctober;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {

	public static void main(String[] args) throws InterruptedException 
	{
       //1) Go to https://www.pepperfry.com/
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudharson-s\\Documents\\chromedriver_win32\\chromedriver.exe");
       ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("https://www.pepperfry.com/");
       
       //2) Mouseover on Furniture and click Office Chairs under Chairs
       WebElement popupclose = driver.findElementByXPath("(//div[@id ='regPopUp']//a)[1]");
       WebDriverWait wait = new WebDriverWait(driver,30);     
       wait.until(ExpectedConditions.visibilityOf(popupclose)).click();       
                         
       WebElement furniture = driver.findElementByXPath("(//div[@id='menu_wrapper']//a)[1]");
       Actions builder = new Actions(driver);
       builder.moveToElement(furniture).perform();
       driver.findElementByLinkText("Office Chairs").click();
       
       //3) click Executive Chairs
       driver.findElementByXPath("//h5[text() ='Executive Chairs']").click();
       
       //4) Change the minimum Height as 50 in under Dimensions
       WebElement Height = driver.findElementByXPath("(//input[@class ='clipFilterDimensionHeightValue'])[1]");
       Height.clear();
       Height.sendKeys("50");
       
       driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
       driver.findElementByClassName("close").click();
       driver.switchTo().defaultContent();
       
      Thread.sleep(8000);
       //5) Add "Buff High Back Executive Chair In Black Colour" chair to Wishlist
       driver.findElementByXPath("//a[@data-productname='Jiffy Executive Chair in Cream Colour']").click();
       
       //6) Mouseover on Bedroom and Click Study table
       WebElement Bedroom = driver.findElementByLinkText("Bedroom");
       Actions builder1 = new Actions(driver);
       builder1.moveToElement(Bedroom).perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Study Tables")));
       driver.findElementByLinkText("Study Tables").click();
       
       //7) Select Spacewood as Brand
       driver.findElementByXPath("//label[@for ='brandsnameSpacewood']").click();
       
       //8) Select Price as 7000 to 8000locator
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='price7000-8000']")));
        try {
    		driver.findElementByXPath("//label[@for='price7000-8000']").click();
    		}
        catch(StaleElementReferenceException e)
        {
    			System.out.println("StaleElementReference exception occured - trying with other xpath");
    			driver.findElementByXPath("(//input[@data-key='price']/following-sibling::label)[3]").click();
    		}
        catch(ElementClickInterceptedException e1) 
        {
    			System.out.println("ElementClickIntercepted exception occured - trying once again");
    			driver.findElementByXPath("//label[@for='price7000-8000']").click();
    		}*/
    		
         int count = 0;
        
         WebElement elem = driver.findElement(By.xpath("//label[@for='price7000-8000']"));
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
                } 
                catch (Exception e) 
                {
                      isClickable = false;
                      count++;
                }
    

       Thread.sleep(10000);
       //9) Add "Winner Hutch Table In Rigato Walnut Finish" to Wishlist
       try {
   		driver.findElementByXPath("//a[@data-productname='Winner Hutch Table in Rigato Walnut Finish']").click();
   		}
       catch(StaleElementReferenceException e) 
       {
   			System.out.println("StaleElementReference exception occured - trying with other xpath");
   			driver.findElementByXPath("(//a[@id='clip_wishlist_'])[1]").click();
   		}
       
       //10) Verify the number of items in Wishlist
       
       
      
	}

}
}


