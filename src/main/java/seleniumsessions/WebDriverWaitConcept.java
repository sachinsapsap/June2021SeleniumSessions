package seleniumsessions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	
	static WebDriver driver;

//	2.Dynamic Wait--->10 seconds --->If element if found within 4 seconds, then rest 6 seconds will be ignored.
//	a) Implicitly Wait
//	b)Explicitly wait--->WebDriverWait class--->FluentWait class--->Wait Interface

	public static void main(String[] args) {

//		Explicit Wait is Custom Wait. We can define our own wait for a specific element. Not a global wait.
//		can be applied for both WebElements and Non WebElements(Alert,Pop up, URL, title)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailID = By.id("input-email");
//		By password = By.id("input-password");
//		By loginBtn = By.xpath("//input[@value='Login']");

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement emailEle = wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
		WebElement emailEle=waitForElementPresence(emailID, 5);
		emailEle.sendKeys("naveen@gmail.com");
		

	}
	
	/**
	 * This method is used to wait till the WebElement is present inside DOM of a page and then return the WebElement.
	 * @param locator Pass the locator of the WebElement.
	 * @param timeout Pass the time duration to wait in seconds.
	 * @return This returns the WebElement.
	 */
	public static WebElement waitForElementPresence(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresence(By locator,int timeout, int intervalTime)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
