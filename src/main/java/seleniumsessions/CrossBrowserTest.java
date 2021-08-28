package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {
	
    static WebDriver driver;	

	public static void main(String[] args) {
		
		String browser="chrome";
		
		if(browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browser not found");
		}

		try {
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		}
		catch(NullPointerException e) {
			System.out.println("Enter correct browser");
		}
		finally {
			System.out.println("Thanks");
		}
	}

}
