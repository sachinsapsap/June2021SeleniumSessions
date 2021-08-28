package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {
	
//	Wait in Selenium : Synchronization concept
//	can be applied for WebElements and Non WebElements(URL,TITLE,ALERT,POPUP etc)
//	Two types:
//	1.Static Wait---->Thread.sleep(5000)--->will pause the script for 5 seconds. Coming from Java.
//	2.Dynamic Wait--->10 seconds --->If element if found within 4 seconds, then rest 6 seconds will be ignored.
//	a) Implicitly Wait
//	b)Explicitly wait--->WebDriverWait class--->FluentWait class--->Wait Interface
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Implicitly Wait : Dynamic Wait
//      Only applicable for WebElements.
//		Global Wait.Applied with driver and it will be called for all upcoming WebElements.
		
//		e1: 5 seconds for WebElement to be visible on the page.
//		imp wait---driver---timeout 10 seconds
//		e1----5 seconds---rest 5 seconds will be ignored.
//		if not found after 10 seconds also then No such Element Exception thrown.
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement emailID=driver.findElement(By.id("input-email"));
		WebElement password=driver.findElement(By.id("input-password"));
		WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
		
		emailID.sendKeys("naveenanimation20@gmail.com");
		password.sendKeys("password123");
		loginBtn.click();
		
//		For home page we need only 5 seconds:
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		For register page we don't need any wait or 0 seconds wait----this is called nullify of implicitly wait.
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	
		
	}

}
