package seleniumsessions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId=By.id("input-email1");
		retryingElement(emailId,20,2000).sendKeys("test");
		
		

	}
	
	public static WebElement retryingElement(By locator,int timeout, int pollingTime) {
		WebElement element=null;
		int attempts=1;
		while(attempts<=timeout) {
			
			 try {
				element=driver.findElement(locator);
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("No of attempts: "+attempts);
			}
			attempts++; 
		}
		return element;
		
	}

}
