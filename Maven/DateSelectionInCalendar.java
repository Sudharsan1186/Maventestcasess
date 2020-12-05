package monday.fiveoctober;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelectionInCalendar {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		LocalDate today = LocalDate.now();
		int Date = today.getDayOfMonth();
		int year = today.getYear();
		int month = today.getMonthValue();
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		System.out.println(year+"-"+(month+1)+"-"+Date);
		//div[@data-testid="datepicker-day-2020-11-14"]
				/*
				 * driver.findElementByXPath("//div[text()='Add dates']").click();
				 * driver.findElementByXPath("//div[@data-testid='datepicker-day-"+year+"-"+
				 * month+"-"+(Date+10)+"']").click();
				 * driver.findElementByXPath("//div[@data-testid='datepicker-day-"+year+"-"+
				 * month+"-"+(Date+15)+"']").click();
				 * driver.findElementByXPath("//div[text()='Add guests']").click();
				 * driver.findElementByXPath(
				 * "//button[@data-testid='stepper-adults-increase-button']//span").click();
				 */
		
		String button = "//*[@id='rb-calendar_onward_cal']/table//tr[1]/td[3]/button";
		driver.findElement(By.xpath(button)).click();
		List<WebElement> firstmonday = driver.findElements(By.xpath("//th[contains(text(),'Mo')]/following::tr/td[1]"));
		List<String> val = new ArrayList<String>();
		

		
		  // Select the date values except space 
		for (WebElement lst : firstmonday) {
		  if (!lst.getText().isEmpty()) 
		  { 
			  val.add(lst.getText());
			  
          } 
		  }
		 
		String first_monday = val.get(0);
		System.out.println("First Monday Date is : " + first_monday);

		// Select first monday from calender
		for (WebElement values : firstmonday) {
			if (values.getText().equals(first_monday)) {
				values.click();
			}
		}

	}

}
