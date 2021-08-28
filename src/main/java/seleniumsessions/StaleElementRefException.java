package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefException {

	public static void main(String[] args) {


//		Stale means not fresh.
//		We get Stale Element Reference Exception when page is refreshed, during pagination, back, forward, navigate to other page
//		DOM gets updated on all above actions
//		To resolve this we need to update our WebElement or List of WebElements.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		
		List<WebElement> footerLinks=driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		
		for(int i=1;i<footerLinks.size();i++) {
			footerLinks.get(i).click();
			footerLinks=driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		}

	}

}
