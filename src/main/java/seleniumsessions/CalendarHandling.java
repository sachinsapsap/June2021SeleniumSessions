package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		Thread.sleep(2000);
		

		selectDate("February", "2021", "28");

	}
	
	/**
	 * This method is used to select date from the calendar.
	 * @param expMonth Pass the month of the date in full like August, December etc. Please make sure month spelling is correct.
	 * @param expYear Pass the year of the date in YYYY format.
	 * @param day Pass the day of the date in DD format.
	 */
	public static void selectDate(String expMonth, String expYear, String day) {
		String actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		
		
		
		
		String traverse=null;
		if(Integer.parseInt(actYear)<Integer.parseInt(expYear)) {
		traverse="Next";
		}
		else if (Integer.parseInt(actYear)>Integer.parseInt(expYear)) {
			traverse="Prev";
		} 
		else {
			if(monthIntegerEquivalent(actMonth)<monthIntegerEquivalent(expMonth)){
			traverse="Next";	
			}
			else {
				traverse="Prev";
			}
		}
			
		
		while(!((actMonth.equalsIgnoreCase(expMonth))&&(actYear.equalsIgnoreCase(expYear)))) {
			driver.findElement(By.xpath("//span[text()='"+traverse+"']")).click();//click on Next or Prev button
			actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		try {
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		}
		catch (Exception e) {
			System.out.println("Invalid Date");
		}
	

}
	/**
	 * This method is used to return Month's integer equivalent. For example: January is 1.
	 * @param month Pass the month for which integer equivalent is to be found out.
	 * @return This returns the integer value of the month.
	 */
	public static int monthIntegerEquivalent(String month) {
		String monthInSmall=month.toLowerCase();
		switch (monthInSmall) {
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		default:
			System.out.println("Invalid Month");
			return -1;
		}
		
		}
	
	/**
	 * This method is used to select future date from the calendar.
	 * @param expMonth Pass the month of the date in full like August, December etc. Please make sure month spelling is correct.
	 * @param expYear Pass the year of the date in YYYY format.
	 * @param day Pass the day of the date in DD format.
	 */
	public static void selectFutureDate(String expMonth, String expYear, String day) {
		String actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		
		
		while(!((actMonth.equalsIgnoreCase(expMonth))&&(actYear.equalsIgnoreCase(expYear)))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();//click on Next button
			actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		try {
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		}
		catch (Exception e) {
			System.out.println("Invalid Date");
		}
	}
	
	/**
	 * This method is used to select past date from the calendar.
	 * @param expMonth Pass the month of the date in full like August, December etc. Please make sure month spelling is correct.
	 * @param expYear Pass the year of the date in YYYY format.
	 * @param day Pass the day of the date in DD format.
	 */
	public static void selectPastDate(String expMonth, String expYear, String day) {
		String actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		
		
		while(!((actMonth.equalsIgnoreCase(expMonth))&&(actYear.equalsIgnoreCase(expYear)))) {
			driver.findElement(By.xpath("//span[text()='Prev']")).click();//click on Prev button
			actMonth=driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			actYear=driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		try {
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		}
		catch (Exception e) {
			System.out.println("Invalid Date");
		}
	}
	
}
