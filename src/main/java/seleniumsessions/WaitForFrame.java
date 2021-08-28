package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//            Default polling time in Selenium is 500ms or 0.5seconds.

public class WaitForFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		driver=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
		
		waitForFrameAndSwitchToIt("mainpanel", 10);
		
		driver.findElement(By.linkText("CONTACTS")).click();

	}
	
	public static void waitForFrameAndSwitchToIt(String frameName,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
	}
	
	public static void waitForFrameAndSwitchToIt(By frameLocator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameAndSwitchToIt(int frameIndex,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameAndSwitchToIt(WebElement frameElement,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

}
