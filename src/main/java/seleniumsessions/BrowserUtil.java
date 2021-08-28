package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This utility is having different methods for browser actions
 * @author Sachin
 *
 */
public class BrowserUtil {
	
	
	public WebDriver driver;
	
	
/**
 * This method is used to initialize the driver on the basis of browser provided.
 * @param browserName Please provide the browser to be tested.
 * @return This returns WebDriver reference
 */
	public WebDriver launchBrowser(String browserName) {
		if(browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browser not found");
		}
	return driver;
	}
	
	/**
	 * This method is used to launch the provided url.
	 * @param url Please provide the url to be launched.
	 */
	public void launchUrl(String url) {
		if(url==null || url.isEmpty()) {
			return;
		}

		driver.get(url);
	}
	
	
/**
 * This method is used to return the Page Title.
 * @return This returns Page title
 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method is used to return the Page URL.
	 * @return This returns Page URL
	 */
		public String getPageUrl() {
			return driver.getCurrentUrl();
		}
	
	/**
	 * This method is used to return Page Source.
	 * @return This returns Page Source
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	/**
	 * This method closes the browser.
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * This method quits the browser.
	 */
	public void quitBrowser() {
		driver.quit();
	}
}
